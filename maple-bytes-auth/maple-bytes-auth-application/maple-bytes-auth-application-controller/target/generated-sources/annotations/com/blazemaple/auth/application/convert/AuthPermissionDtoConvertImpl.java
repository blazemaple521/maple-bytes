package com.blazemaple.auth.application.convert;

import com.blazemaple.auth.application.dto.AuthPermissionDTO;
import com.blazemaple.auth.domain.entity.AuthPermissionBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-01T13:53:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthPermissionDtoConvertImpl implements AuthPermissionDtoConvert {

    @Override
    public AuthPermissionBO convertDtoToBo(AuthPermissionDTO authPermissionDTO) {
        if ( authPermissionDTO == null ) {
            return null;
        }

        AuthPermissionBO authPermissionBO = new AuthPermissionBO();

        authPermissionBO.setId( authPermissionDTO.getId() );
        authPermissionBO.setName( authPermissionDTO.getName() );
        authPermissionBO.setParentId( authPermissionDTO.getParentId() );
        authPermissionBO.setType( authPermissionDTO.getType() );
        authPermissionBO.setMenuUrl( authPermissionDTO.getMenuUrl() );
        authPermissionBO.setStatus( authPermissionDTO.getStatus() );
        authPermissionBO.setShow( authPermissionDTO.getShow() );
        authPermissionBO.setIcon( authPermissionDTO.getIcon() );
        authPermissionBO.setPermissionKey( authPermissionDTO.getPermissionKey() );

        return authPermissionBO;
    }

    @Override
    public AuthPermissionDTO convertBoToDto(AuthPermissionBO authPermissionBO) {
        if ( authPermissionBO == null ) {
            return null;
        }

        AuthPermissionDTO authPermissionDTO = new AuthPermissionDTO();

        authPermissionDTO.setId( authPermissionBO.getId() );
        authPermissionDTO.setName( authPermissionBO.getName() );
        authPermissionDTO.setParentId( authPermissionBO.getParentId() );
        authPermissionDTO.setType( authPermissionBO.getType() );
        authPermissionDTO.setMenuUrl( authPermissionBO.getMenuUrl() );
        authPermissionDTO.setStatus( authPermissionBO.getStatus() );
        authPermissionDTO.setShow( authPermissionBO.getShow() );
        authPermissionDTO.setIcon( authPermissionBO.getIcon() );
        authPermissionDTO.setPermissionKey( authPermissionBO.getPermissionKey() );

        return authPermissionDTO;
    }
}
