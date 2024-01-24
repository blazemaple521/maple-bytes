package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.infra.basic.entity.SubjectBrief;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BriefSubjectConvert {

    BriefSubjectConvert INSTANCE = Mappers.getMapper(BriefSubjectConvert.class);

    SubjectBrief convertBoToBrief(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertToBriefBoList(List<SubjectInfo> subjectInfoList);
}
