package com.blazemaple.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthUserRole)实体类
 *
 * @author makejava
 * @since 2024-01-31 16:44:17
 */
@Data
public class AuthUserRole implements Serializable {

    private static final long serialVersionUID = -82477875609198577L;

    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer isDeleted;


}

