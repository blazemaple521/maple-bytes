package com.blazemaple.subject.domain.convert;

import com.blazemaple.subject.domain.entity.SubjectCategoryBO;
import com.blazemaple.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/18 21:50
 */
@Mapper
public interface SubjectCategoryConvert {

    SubjectCategoryConvert INSTANCE = Mappers.getMapper(SubjectCategoryConvert.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertToCategoryBoList(List<SubjectCategory> categoryList);
}
