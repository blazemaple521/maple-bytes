package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthRoleDTO;
import com.blazemaple.auth.domain.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:06
 */
@Mapper
public interface AuthRoleDtoConvert {

    AuthRoleDtoConvert INSTANCE = Mappers.getMapper(AuthRoleDtoConvert.class);

    AuthRoleBO convertDtoToBo(AuthRoleDTO authRoleDTO);

    AuthRoleDTO convertBoToDto(AuthRoleBO authRoleBO);
}
