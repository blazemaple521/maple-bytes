package com.blazemaple.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description 题目答案DTO
 *
 * @author BlazeMaple
 * @date 2024/1/22 15:59
 */
@Data
public class SubjectAnswerDTO implements Serializable {

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

