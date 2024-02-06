package com.blazemaple.auth.infra.basic.service;

import com.blazemaple.auth.infra.basic.entity.AuthRolePermission;

import java.util.List;

/**
 * (AuthRolePermission)表服务接口
 *
 * @author makejava
 * @since 2024-01-31 16:40:15
 */
public interface AuthRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Long id);


    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission insert(AuthRolePermission authRolePermission);

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 通过条件查询数据
     * @param authRolePermission 查询条件
     * @return 对象列表
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);

    /**
     * 批量插入
     * @param rolePermissionList 插入数据
     * @return 插入数量
     */
    int batchInsert(List<AuthRolePermission> rolePermissionList);
}
