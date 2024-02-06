package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthPermissionDTO;
import com.blazemaple.auth.domain.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/2/1 13:06
 */
@Mapper
public interface AuthPermissionDtoConvert {

    AuthPermissionDtoConvert INSTANCE = Mappers.getMapper(AuthPermissionDtoConvert.class);

    AuthPermissionBO convertDtoToBo(AuthPermissionDTO authPermissionDTO);

    AuthPermissionDTO convertBoToDto(AuthPermissionBO authPermissionBO);
}
