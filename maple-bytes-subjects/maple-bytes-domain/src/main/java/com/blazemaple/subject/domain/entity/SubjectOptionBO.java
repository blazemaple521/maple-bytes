package com.blazemaple.subject.domain.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * @description 题目选项
 *
 * @author BlazeMaple
 * @date 2024/1/22 16:41
 */
@Data
public class SubjectOptionBO implements Serializable {

    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<SubjectAnswerBO> optionList;

}
