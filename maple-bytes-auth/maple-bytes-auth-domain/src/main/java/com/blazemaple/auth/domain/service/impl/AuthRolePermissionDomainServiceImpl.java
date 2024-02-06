package com.blazemaple.auth.domain.service.impl;

import com.blazemaple.auth.common.enums.IsDeletedFlagEnum;
import com.blazemaple.auth.domain.entity.AuthRolePermissionBO;
import com.blazemaple.auth.domain.service.AuthRolePermissionDomainService;
import com.blazemaple.auth.infra.basic.entity.AuthRolePermission;
import com.blazemaple.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:38
 */
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService authRolePermissionService;


    @Override
    public Boolean add(AuthRolePermissionBO rolePermissionBO) {
        List<AuthRolePermission> rolePermissionList = new LinkedList<>();
        Long roleId = rolePermissionBO.getRoleId();
        rolePermissionBO.getPermissionIdList().forEach(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(roleId);
            authRolePermission.setPermissionId(permissionId);
            authRolePermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            rolePermissionList.add(authRolePermission);
        });
        int count = authRolePermissionService.batchInsert(rolePermissionList);
        return count > 0;

    }
}
