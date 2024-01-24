package com.blazemaple.subject.domain.handler.subject;

import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.common.enums.SubjectInfoTypeEnum;
import com.blazemaple.subject.domain.convert.MultipleSubjectConvert;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.infra.basic.entity.SubjectMultiple;
import com.blazemaple.subject.infra.basic.service.SubjectInfoService;
import com.blazemaple.subject.infra.basic.service.SubjectMappingService;
import com.blazemaple.subject.infra.basic.service.SubjectMultipleService;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:45
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        Preconditions.checkArgument(!subjectInfoBO.getOptionList().isEmpty(), "选项不能为空");
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = MultipleSubjectConvert.INSTANCE.convertBoToMultiple(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }

    @Override
    public SubjectOptionBO query(long subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(subjectId);
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectInfoBoList = MultipleSubjectConvert.INSTANCE.convertMultipleListToInfoBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectInfoBoList);
        return subjectOptionBO;
    }
}
