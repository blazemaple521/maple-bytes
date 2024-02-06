package com.blazemaple.auth.domain.service.impl;

import com.blazemaple.auth.common.enums.IsDeletedFlagEnum;
import com.blazemaple.auth.domain.convert.AuthPermissionBoConvert;
import com.blazemaple.auth.domain.entity.AuthPermissionBO;
import com.blazemaple.auth.domain.redis.RedisUtil;
import com.blazemaple.auth.domain.service.AuthPermissionDomainService;
import com.blazemaple.auth.infra.basic.entity.AuthPermission;
import com.blazemaple.auth.infra.basic.service.AuthPermissionService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:17
 */
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;

    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";


    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBoConvert.INSTANCE.convertBoToEntity(authPermissionBO);
        authPermission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        Integer count = authPermissionService.insert(authPermission);
        return count > 0;
    }

    @Override
    public Boolean update(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = AuthPermissionBoConvert.INSTANCE.convertBoToEntity(permissionBO);
        Integer count = authPermissionService.update(authPermission);
        return count > 0;

    }

    @Override
    public Boolean delete(AuthPermissionBO permissionBO) {
        AuthPermission authPermission = new AuthPermission();
        authPermission.setId(permissionBO.getId());
        authPermission.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        Integer count = authPermissionService.update(authPermission);
        return count > 0;

    }

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)) {
            return Collections.emptyList();
        }
        List<AuthPermission> permissionList = new Gson().fromJson(permissionValue,
            new TypeToken<List<AuthPermission>>() {
            }.getType());
        List<String> authList = permissionList.stream().map(AuthPermission::getPermissionKey)
            .collect(Collectors.toList());
        return authList;

    }
}
