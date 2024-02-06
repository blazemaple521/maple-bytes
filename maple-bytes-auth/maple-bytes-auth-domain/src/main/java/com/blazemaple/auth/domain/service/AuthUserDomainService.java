package com.blazemaple.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.blazemaple.auth.domain.entity.AuthUserBO;

/**
 * @author BlazeMaple
 * @description
 * @date 2024/1/30 23:28
 */
public interface AuthUserDomainService {

    Boolean register(AuthUserBO authUserBO);

    Boolean update(AuthUserBO authUserBO);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);
}
