package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubjectInfoConvert {

    SubjectInfoConvert INSTANCE = Mappers.getMapper(SubjectInfoConvert.class);

    SubjectInfo convertBoToInfo(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertToInfoBoList(List<SubjectInfo> subjectInfoList);

    SubjectInfoBO convertOptionAndInfoToBo(SubjectOptionBO subjectOptionBO,SubjectInfo subjectInfo);
}
