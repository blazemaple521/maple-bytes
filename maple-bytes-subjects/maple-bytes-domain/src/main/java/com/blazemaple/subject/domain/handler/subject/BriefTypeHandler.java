package com.blazemaple.subject.domain.handler.subject;

import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.common.enums.SubjectInfoTypeEnum;
import com.blazemaple.subject.domain.convert.BriefSubjectConvert;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.infra.basic.entity.SubjectBrief;
import com.blazemaple.subject.infra.basic.service.SubjectBriefService;
import com.blazemaple.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:45
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConvert.INSTANCE.convertBoToBrief(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(long subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;

    }
}
