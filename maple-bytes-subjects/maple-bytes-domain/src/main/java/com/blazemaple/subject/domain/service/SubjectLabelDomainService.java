package com.blazemaple.subject.domain.service;

import com.blazemaple.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/21 16:06
 */
public interface SubjectLabelDomainService {

    void add(SubjectLabelBO subjectLabelBO);

    Boolean update(SubjectLabelBO subjectLabelBO);

    Boolean delete(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> queryLabelByCategoryId(SubjectLabelBO subjectLabelBO);
}
