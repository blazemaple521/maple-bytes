package com.blazemaple.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.blazemaple.subject.common.enums.CategoryTypeEnum;
import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.domain.convert.SubjectLabelConvert;
import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import com.blazemaple.subject.domain.service.SubjectLabelDomainService;
import com.blazemaple.subject.infra.basic.entity.SubjectCategory;
import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import com.blazemaple.subject.infra.basic.entity.SubjectMapping;
import com.blazemaple.subject.infra.basic.service.SubjectCategoryService;
import com.blazemaple.subject.infra.basic.service.SubjectLabelService;
import com.blazemaple.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/21 16:07
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("add subject label, subjectLabelBO: {}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANCE
            .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectLabelService.insert(subjectLabel);
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANCE
            .convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANCE
            .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO) {
        //如果当前分类是1级分类，则查询所有标签
        SubjectCategory subjectCategory = subjectCategoryService.queryById(subjectLabelBO.getCategoryId());
        if(CategoryTypeEnum.PRIMARY.getCode() == subjectCategory.getCategoryType()){
            SubjectLabel subjectLabel = new SubjectLabel();
            subjectLabel.setCategoryId(subjectLabelBO.getCategoryId());
            List<SubjectLabel> labelList = subjectLabelService.queryByCondition(subjectLabel);
            List<SubjectLabelBO> labelResultList = SubjectLabelConvert.INSTANCE.convertToLabelBoList(labelList);
            return labelResultList;
        }


        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setCategoryId(categoryId);
            bo.setSortNum(label.getSortNum());
            boList.add(bo);
        });
        return boList;


    }
}
