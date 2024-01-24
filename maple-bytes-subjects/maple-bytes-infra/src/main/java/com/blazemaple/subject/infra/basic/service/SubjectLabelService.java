package com.blazemaple.subject.infra.basic.service;

import com.blazemaple.subject.infra.basic.entity.SubjectLabel;
import java.util.List;


/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-01-21 15:45:20
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    int update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过主键批量删除数据
     * @param labelIdList 主键列表
     * @return 标签列表
     */
    List<SubjectLabel> batchQueryById(List<Long> labelIdList);

    /**
     * 查询指定行数据
     *
     * @param subjectLabel 查询条件
     * @return 对象列表
     */
    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);

}
