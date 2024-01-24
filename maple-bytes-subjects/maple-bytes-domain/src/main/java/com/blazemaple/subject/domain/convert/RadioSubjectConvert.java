package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import com.blazemaple.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface RadioSubjectConvert {

    RadioSubjectConvert INSTANCE = Mappers.getMapper(RadioSubjectConvert.class);

    SubjectRadio convertBoToRadio(SubjectAnswerBO subjectAnswerBO);

    List<SubjectInfoBO> convertToRadioBoList(List<SubjectInfo> subjectInfoList);

    List<SubjectAnswerBO> convertRadioListToInfoBoList(List<SubjectRadio> result);
}
