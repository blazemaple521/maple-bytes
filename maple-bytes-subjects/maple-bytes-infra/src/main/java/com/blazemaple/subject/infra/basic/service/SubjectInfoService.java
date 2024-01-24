package com.blazemaple.subject.infra.basic.service;

import com.blazemaple.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务接口
 *
 * @author makejava
 * @since 2024-01-22 15:12:44
 */
public interface SubjectInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectInfo queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    SubjectInfo update(SubjectInfo subjectInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据条件查询数量
     * @param subjectInfo 查询条件
     * @param categoryId 分类id
     * @param labelId 标签id
     * @return 数量
     */
    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    /**
     * 根据条件分页查询
     * @param subjectInfo 查询条件
     * @param categoryId 分类id
     * @param labelId 标签id
     * @param start 起始位置
     * @param pageSize 每页数量
     * @return 集合
     */
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);
}
