package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectMultiple;
import com.blazemaple.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface MultipleSubjectConvert {

    MultipleSubjectConvert INSTANCE = Mappers.getMapper(MultipleSubjectConvert.class);

    SubjectMultiple convertBoToMultiple(SubjectAnswerBO subjectAnswerBO);

    List<SubjectInfoBO> convertToMultipleBoList(List<SubjectInfo> subjectInfoList);

    List<SubjectAnswerBO> convertMultipleListToInfoBoList(List<SubjectMultiple> subjectMultipleList);
}
