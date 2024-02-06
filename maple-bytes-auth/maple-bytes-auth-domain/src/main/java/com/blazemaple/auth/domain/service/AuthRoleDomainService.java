package com.blazemaple.auth.domain.service;

import com.blazemaple.auth.domain.entity.AuthRoleBO;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 11:24
 */
public interface AuthRoleDomainService {

    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}
