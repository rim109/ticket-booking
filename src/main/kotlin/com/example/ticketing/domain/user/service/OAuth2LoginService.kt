package com.example.ticketing.domain.user.service

import com.example.ticketing.common.oauth.client.OAuth2ClientService
import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.common.security.jwt.JwtPlugin
import org.springframework.stereotype.Service

@Service
class OAuth2LoginService(
    private val oAuth2ClientService: OAuth2ClientService,
    private val socialUserService: SocialUserService,
    private val jwtPlugin: JwtPlugin
) {

    fun login(provider: OAuth2Provider, authorizationCode: String): String {
//        val userInfo = oAuth2ClientService.login(provider, authorizationCode)
//        val user = socialUserService.registerIfAbsent(userInfo)
//        val accessToken = jwtPlugin.generateAccessToken(user.id.toString(), user.email, user.role.name)
        // 인가코드로 액세스 토큰 얻고, 액세스 토큰으로 사용자 정보 조회
        return oAuth2ClientService.getUserInfo(provider, authorizationCode)
            // 사용자 정보로 social user 없으면 회원가입, 있으면 조회
            .let { socialUserService.registerIfAbsent(it) }
            // social user 정보로 우리 쪽 액세스 토큰 발급
            .let { jwtPlugin.generateAccessToken(it.id!!.toString(), it.role.toString()) }
    }

}