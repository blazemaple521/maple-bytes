package com.blazemaple.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.blazemaple.subject.common.entity.PageResult;
import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.domain.convert.SubjectInfoConvert;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.domain.handler.subject.SubjectTypeHandler;
import com.blazemaple.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.blazemaple.subject.domain.service.SubjectInfoDomainService;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import com.blazemaple.subject.infra.basic.entity.SubjectMapping;
import com.blazemaple.subject.infra.basic.service.SubjectInfoService;
import com.blazemaple.subject.infra.basic.service.SubjectLabelService;
import com.blazemaple.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:20
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectLabelService subjectLabelService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("add subject, subjectInfoBO: {}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConvert.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfoBO.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
        handler.add(subjectInfoBO);

        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> subjectMappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConvert.INSTANCE.convertBoToInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(),
            subjectInfoBO.getLabelId());
        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId()
            , subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoB0List = SubjectInfoConvert.INSTANCE.convertToInfoBoList(subjectInfoList);
        subjectInfoB0List.forEach(infoBo ->{
            List<String> labelNameList = getLabelNameList(infoBo.getId());
            infoBo.setLabelName(labelNameList);
        });
        pageResult.setRecords(subjectInfoB0List);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfoBO.getId());
        SubjectInfoBO infoBO = SubjectInfoConvert.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        List<String> labelNameList = getLabelNameList(subjectInfo.getId());
        infoBO.setLabelName(labelNameList);
        return infoBO;
    }

    private List<String> getLabelNameList(Long infoId) {
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(infoId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (subjectMappingList.isEmpty()) {
            return null;
        }
        List<Long> labelIdList = subjectMappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> subjectLabelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = subjectLabelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        return labelNameList;
    }

}
