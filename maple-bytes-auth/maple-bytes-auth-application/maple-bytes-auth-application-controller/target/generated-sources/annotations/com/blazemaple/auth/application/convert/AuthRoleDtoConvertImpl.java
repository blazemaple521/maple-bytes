package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthRoleDTO;
import com.blazemaple.auth.domain.entity.AuthRoleBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-01T13:53:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthRoleDtoConvertImpl implements AuthRoleDtoConvert {

    @Override
    public AuthRoleBO convertDtoToBo(AuthRoleDTO authRoleDTO) {
        if ( authRoleDTO == null ) {
            return null;
        }

        AuthRoleBO authRoleBO = new AuthRoleBO();

        authRoleBO.setId( authRoleDTO.getId() );
        authRoleBO.setRoleName( authRoleDTO.getRoleName() );
        authRoleBO.setRoleKey( authRoleDTO.getRoleKey() );

        return authRoleBO;
    }

    @Override
    public AuthRoleDTO convertBoToDto(AuthRoleBO authRoleBO) {
        if ( authRoleBO == null ) {
            return null;
        }

        AuthRoleDTO authRoleDTO = new AuthRoleDTO();

        authRoleDTO.setId( authRoleBO.getId() );
        authRoleDTO.setRoleName( authRoleBO.getRoleName() );
        authRoleDTO.setRoleKey( authRoleBO.getRoleKey() );

        return authRoleDTO;
    }
}
