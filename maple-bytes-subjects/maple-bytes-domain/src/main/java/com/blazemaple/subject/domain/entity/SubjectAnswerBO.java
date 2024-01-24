package com.blazemaple.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description 题目答案BO
 *
 * @author BlazeMaple
 * @date 2024/1/22 15:59
 */
@Data
public class SubjectAnswerBO implements Serializable {

    /**
     * 答案选项标识
     */
    private Integer optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;

}

