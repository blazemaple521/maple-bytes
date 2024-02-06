package com.blazemaple.auth.domain.convert;

import com.blazemaple.auth.domain.entity.AuthUserBO;
import com.blazemaple.auth.infra.basic.entity.AuthUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/30 23:29
 */
@Mapper
public interface AuthUserBoConvert {

    AuthUserBoConvert INSTANCE = Mappers.getMapper(AuthUserBoConvert.class);

    AuthUser convertBOToEntity(AuthUserBO authUserBO);

    AuthUserBO convertEntityToBO(AuthUser user);
}
