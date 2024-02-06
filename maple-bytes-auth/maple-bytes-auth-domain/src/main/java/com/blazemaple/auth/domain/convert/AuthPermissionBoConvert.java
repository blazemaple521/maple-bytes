package com.blazemaple.auth.domain.convert;

import com.blazemaple.auth.domain.entity.AuthPermissionBO;
import com.blazemaple.auth.infra.basic.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:10
 */
@Mapper
public interface AuthPermissionBoConvert {
    
    AuthPermissionBoConvert INSTANCE = Mappers.getMapper(AuthPermissionBoConvert.class);

    AuthPermissionBO convertEntityToBo(AuthPermission authPermission);

    AuthPermission convertBoToEntity(AuthPermissionBO authPermissionBO);
}
