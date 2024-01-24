package com.blazemaple.subject.domain.handler.subject;


import com.blazemaple.subject.common.enums.SubjectInfoTypeEnum;
import com.blazemaple.subject.domain.entity.SubjectInfoBO;
import com.blazemaple.subject.domain.entity.SubjectOptionBO;

public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 实际的题目的查询
     * @param subjectId 题目id
     * @return 题目详情
     */
     SubjectOptionBO query(long subjectId);

}
