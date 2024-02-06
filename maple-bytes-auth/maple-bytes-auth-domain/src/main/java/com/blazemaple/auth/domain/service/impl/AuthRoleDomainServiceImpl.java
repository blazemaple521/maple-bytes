package com.blazemaple.auth.domain.service.impl;

import com.blazemaple.auth.common.enums.IsDeletedFlagEnum;
import com.blazemaple.auth.domain.convert.AuthRoleBoConvert;
import com.blazemaple.auth.domain.entity.AuthRoleBO;
import com.blazemaple.auth.domain.service.AuthRoleDomainService;
import com.blazemaple.auth.infra.basic.entity.AuthRole;
import com.blazemaple.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 11:24
 */
@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;

    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBoConvert.INSTANCE.convertBOToEntity(authRoleBO);
        authRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authRoleService.insert(authRole);
        return count > 0;

    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBoConvert.INSTANCE.convertBOToEntity(authRoleBO);
        Integer count = authRoleService.update(authRole);
        return count > 0;

    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        AuthRole authRole = new AuthRole();
        authRole.setId(authRoleBO.getId());
        authRole.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authRoleService.update(authRole);
        return count > 0;

    }
}
