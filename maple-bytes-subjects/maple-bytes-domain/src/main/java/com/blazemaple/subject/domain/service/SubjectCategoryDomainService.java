package com.blazemaple.subject.domain.service;

import com.blazemaple.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/18 21:40
 */
public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 修改分类
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
