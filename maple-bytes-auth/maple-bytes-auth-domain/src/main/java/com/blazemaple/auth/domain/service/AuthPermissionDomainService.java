package com.blazemaple.auth.domain.service;

import com.blazemaple.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:17
 */
public interface AuthPermissionDomainService {

    Boolean add(AuthPermissionBO permissionBO);

    Boolean update(AuthPermissionBO permissionBO);

    Boolean delete(AuthPermissionBO permissionBO);

    List<String> getPermission(String userName);
}
