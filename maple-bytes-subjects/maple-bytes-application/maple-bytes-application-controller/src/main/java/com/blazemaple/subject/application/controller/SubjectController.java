package com.blazemaple.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.blazemaple.subject.application.convert.SubjectAnswerDTOConvert;
import com.blazemaple.subject.application.convert.SubjectCategoryDTOConvert;
import com.blazemaple.subject.application.convert.SubjectInfoDTOConvert;
import com.blazemaple.subject.application.dto.SubjectCategoryDTO;
import com.blazemaple.subject.application.dto.SubjectInfoDTO;
import com.blazemaple.subject.common.entity.Result;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectCategoryBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.service.SubjectInfoDomainService;
import com.blazemaple.subject.infra.basic.entity.SubjectCategory;
import com.blazemaple.subject.infra.basic.service.SubjectCategoryService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BlazeMaple
 * @description 题目Controller
 * @date 2024/1/18 17:35
 */
@Slf4j
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;


    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("add subject, subjectInfoDTO: {}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(), "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(), "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds())
                , "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds())
                , "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANCE.convertDtoToInfoBo(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS =
                SubjectAnswerDTOConvert.INSTANCE.convertDtoListToAnswerBoList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);

            return Result.ok(true);
        } catch (Exception e) {
            log.error("add subject error, error: {}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }


}
