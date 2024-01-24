package com.blazemaple.subject.application.convert;

import com.blazemaple.subject.application.dto.SubjectLabelDTO;
import com.blazemaple.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author BlazeMaple
 * @description 题目标签DTO转换类
 * @date 2024/1/21 16:02
 */
@Mapper
public interface SubjectLabelDTOConvert {

    SubjectLabelDTOConvert INSTANCE = Mappers.getMapper(SubjectLabelDTOConvert.class);

    SubjectLabelBO convertDtoToLabelBo(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBoListToLabelDtoList(List<SubjectLabelBO> subjectLabelBOList);

}
