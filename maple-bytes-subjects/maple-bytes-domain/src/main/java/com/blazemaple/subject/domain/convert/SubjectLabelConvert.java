package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubjectLabelConvert {

    SubjectLabelConvert INSTANCE = Mappers.getMapper(SubjectLabelConvert.class);

    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertToLabelBoList(List<SubjectLabel> subjectLabelList);
}
