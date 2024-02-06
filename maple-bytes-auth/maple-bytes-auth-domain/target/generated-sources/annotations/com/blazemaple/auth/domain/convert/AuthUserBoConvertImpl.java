package com.blazemaple.auth.domain.convert;

import com.blazemaple.auth.domain.entity.AuthUserBO;
import com.blazemaple.auth.infra.basic.entity.AuthUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-01T13:53:31+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_371 (Oracle Corporation)"
)
public class AuthUserBoConvertImpl implements AuthUserBoConvert {

    @Override
    public AuthUser convertBOToEntity(AuthUserBO authUserBO) {
        if ( authUserBO == null ) {
            return null;
        }

        AuthUser authUser = new AuthUser();

        authUser.setId( authUserBO.getId() );
        authUser.setUserName( authUserBO.getUserName() );
        authUser.setNickName( authUserBO.getNickName() );
        authUser.setEmail( authUserBO.getEmail() );
        authUser.setPhone( authUserBO.getPhone() );
        authUser.setPassword( authUserBO.getPassword() );
        authUser.setSex( authUserBO.getSex() );
        authUser.setAvatar( authUserBO.getAvatar() );
        authUser.setStatus( authUserBO.getStatus() );
        authUser.setIntroduce( authUserBO.getIntroduce() );
        authUser.setExtJson( authUserBO.getExtJson() );

        return authUser;
    }

    @Override
    public AuthUserBO convertEntityToBO(AuthUser user) {
        if ( user == null ) {
            return null;
        }

        AuthUserBO authUserBO = new AuthUserBO();

        authUserBO.setId( user.getId() );
        authUserBO.setUserName( user.getUserName() );
        authUserBO.setNickName( user.getNickName() );
        authUserBO.setEmail( user.getEmail() );
        authUserBO.setPhone( user.getPhone() );
        authUserBO.setPassword( user.getPassword() );
        authUserBO.setSex( user.getSex() );
        authUserBO.setAvatar( user.getAvatar() );
        authUserBO.setStatus( user.getStatus() );
        authUserBO.setIntroduce( user.getIntroduce() );
        authUserBO.setExtJson( user.getExtJson() );

        return authUserBO;
    }
}
