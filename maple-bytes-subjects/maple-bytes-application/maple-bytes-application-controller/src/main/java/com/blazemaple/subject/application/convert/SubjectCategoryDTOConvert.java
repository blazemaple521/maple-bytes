package com.blazemaple.subject.application.convert;

import com.blazemaple.subject.application.dto.SubjectCategoryDTO;
import com.blazemaple.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/18 21:50
 */
@Mapper
public interface SubjectCategoryDTOConvert {

    SubjectCategoryDTOConvert INSTANCE = Mappers.getMapper(SubjectCategoryDTOConvert.class);

    List<SubjectCategoryDTO> convertBoListToCategoryDtoList(List<SubjectCategoryBO> subjectCategoryBOList);

    SubjectCategoryBO convertDtoToCategoryBo(SubjectCategoryDTO subjectCategoryDTO);
}
