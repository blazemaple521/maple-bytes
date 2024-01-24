package com.blazemaple.subject.domain.service;

import com.blazemaple.subject.common.entity.PageResult;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/22 16:20
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     *
     * @param subjectInfoBO 题目信息
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询题目
     *
     * @param subjectInfoBO 查询条件
     * @return 分页结果
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查询题目详情
     * @param subjectInfoBO 查询条件
     * @return 题目详情
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
