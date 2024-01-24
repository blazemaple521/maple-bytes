package com.blazemaple.subject.domain.convert;


import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.infra.basic.entity.SubjectInfo;
import com.blazemaple.subject.infra.basic.entity.SubjectJudge;
import com.blazemaple.subject.infra.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface JudgeSubjectConvert {

    JudgeSubjectConvert INSTANCE = Mappers.getMapper(JudgeSubjectConvert.class);

    SubjectJudge convertBoToJudge(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertToJudgeBoList(List<SubjectInfo> subjectInfoList);
    List<SubjectAnswerBO> convertJudgeListToAnswerBoList(List<SubjectJudge> subjectJudge);
}
