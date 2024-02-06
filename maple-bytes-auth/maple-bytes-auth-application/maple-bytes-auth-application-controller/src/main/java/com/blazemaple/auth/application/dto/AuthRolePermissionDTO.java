package com.blazemaple.auth.application.dto;

import lombok.Data;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:39
 */
@Data
public class AuthRolePermissionDTO {

    private Long id;

    private Long roleId;

    private Long permissionId;

    private List<Long> permissionIdList;

}
