package com.blazemaple.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签表(SubjectLabel)实体类
 *
 * @author makejava
 * @since 2024-01-21 15:45:20
 */
@Data
public class SubjectLabelDTO implements Serializable {

    private static final long serialVersionUID = 940300579086901625L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;

}

