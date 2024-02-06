package com.blazemaple.auth.domain.convert;

import com.blazemaple.auth.domain.entity.AuthRoleBO;
import com.blazemaple.auth.infra.basic.entity.AuthRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:10
 */
@Mapper
public interface AuthRoleBoConvert {
    
    AuthRoleBoConvert INSTANCE = Mappers.getMapper(AuthRoleBoConvert.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);
}
