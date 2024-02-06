package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthRolePermissionDTO;
import com.blazemaple.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:06
 */
@Mapper
public interface AuthRolePermissionDtoConvert {

    AuthRolePermissionDtoConvert INSTANCE = Mappers.getMapper(AuthRolePermissionDtoConvert.class);

    AuthRolePermissionBO convertDtoToBo(AuthRolePermissionDTO authRolePermissionDTO);
}
