package com.blazemaple.auth.infra.basic.service;

import com.blazemaple.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
 * (AuthUser)表服务接口
 *
 * @author makejava
 * @since 2024-01-30 23:18:45
 */
public interface AuthUserService {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthUser queryById(Long id);

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer insert(AuthUser authUser);

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    Integer update(AuthUser authUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据条件查询
     * @param authUser 查询条件
     * @return 用户列表
     */
    List<AuthUser> queryByCondition(AuthUser authUser);

    /**
     * 根据用户名更新用户信息
     * @param authUser 用户信息
     * @return 更新条数
     */
    Integer updateByUserName(AuthUser authUser);


}
