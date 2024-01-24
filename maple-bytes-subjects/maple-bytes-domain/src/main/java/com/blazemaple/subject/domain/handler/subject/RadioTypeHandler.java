package com.blazemaple.subject.domain.handler.subject;

import com.blazemaple.subject.common.enums.IsDeletedFlagEnum;
import com.blazemaple.subject.common.enums.SubjectInfoTypeEnum;
import com.blazemaple.subject.domain.convert.RadioSubjectConvert;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.infra.basic.entity.SubjectRadio;
import com.blazemaple.subject.infra.basic.service.SubjectRadioService;
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
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        Preconditions.checkArgument(!subjectInfoBO.getOptionList().isEmpty(), "选项不能为空");
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = RadioSubjectConvert.INSTANCE.convertBoToRadio(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }

    @Override
    public SubjectOptionBO query(long subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(subjectId);
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectInfoBoList = RadioSubjectConvert.INSTANCE.convertRadioListToInfoBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectInfoBoList);
        return subjectOptionBO;
    }
}
