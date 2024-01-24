package com.blazemaple.subject.application.convert;

import com.blazemaple.subject.application.dto.SubjectCategoryDTO;
import com.blazemaple.subject.application.dto.SubjectInfoDTO;
import com.blazemaple.subject.common.entity.PageResult;
import com.blazemaple.subject.domain.entity.SubjectCategoryBO;
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
public interface SubjectInfoDTOConvert {

    SubjectInfoDTOConvert INSTANCE = Mappers.getMapper(SubjectInfoDTOConvert.class);

    List<SubjectInfoDTO> convertBoListToInfoDtoList(List<SubjectInfoBO> subjectInfoBOList);

    SubjectInfoBO convertDtoToInfoBo(SubjectInfoDTO subjectInfoDTO);
    SubjectInfoDTO convertBoToInfoDto(SubjectInfoBO subjectInfoBO);

    PageResult<SubjectInfoDTO> convertBoPageResultToInfoDtoPageResult(PageResult<SubjectInfoBO> subjectInfoBOPageResult);

}
