package com.example.ticketing.domain.user.controller

import com.example.ticketing.common.oauth.client.kakao.KakaoOAuth2Client
import com.example.ticketing.domain.user.service.OAuth2LoginService

class OAuth2LoginController(
    private val kakaoOAuth2Client: KakaoOAuth2Client,
    private val oAuth2LoginService: OAuth2LoginService
) {
}