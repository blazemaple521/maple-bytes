package com.blazemaple.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (AuthPermission)实体类
 *
 * @author makejava
 * @since 2024-01-31 16:36:31
 */
@Data
public class AuthPermissionBO implements Serializable {


    private Long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 权限类型 0菜单 1操作
     */
    private Integer type;
    /**
     * 菜单路由
     */
    private String menuUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 展示状态 0展示 1隐藏
     */
    private Integer show;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限唯一标识
     */
    private String permissionKey;

}

