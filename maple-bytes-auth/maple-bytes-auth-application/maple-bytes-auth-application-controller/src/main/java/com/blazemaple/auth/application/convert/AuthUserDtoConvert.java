package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthUserDTO;
import com.blazemaple.auth.domain.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/30 23:31
 */
@Mapper
public interface AuthUserDtoConvert {

    AuthUserDtoConvert INSTANCE = Mappers.getMapper(AuthUserDtoConvert.class);

    AuthUserBO convertDTOToBO(AuthUserDTO authUserDTO);

    AuthUserDTO convertBoToDto(AuthUserBO authUserBO);
}
