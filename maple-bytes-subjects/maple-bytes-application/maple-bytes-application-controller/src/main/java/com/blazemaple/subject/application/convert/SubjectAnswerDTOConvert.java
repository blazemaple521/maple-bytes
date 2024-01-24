package com.blazemaple.subject.application.convert;

import com.blazemaple.subject.application.dto.SubjectAnswerDTO;
import com.blazemaple.subject.application.dto.SubjectInfoDTO;
import com.blazemaple.subject.domain.entity.SubjectAnswerBO;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:07
 */
@Mapper
public interface SubjectAnswerDTOConvert {

    SubjectAnswerDTOConvert INSTANCE = Mappers.getMapper(SubjectAnswerDTOConvert.class);

    List<SubjectAnswerDTO> convertBoListToAnswerDtoList(List<SubjectAnswerBO> subjectAnswerBOList);
    List<SubjectAnswerBO> convertDtoListToAnswerBoList(List<SubjectAnswerDTO> subjectAnswerDTOList);
    SubjectAnswerBO convertDtoToAnswerBo(SubjectAnswerDTO subjectAnswerDTO);

}
