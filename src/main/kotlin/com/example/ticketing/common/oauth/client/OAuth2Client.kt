package com.example.ticketing.common.oauth.client

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo

interface OAuth2Client {
    fun generateLoginPageUrl(): String
    fun getAccessToken(authorizationCode: String): String
    fun retrieveUserInfo(accessToken: String): OAuth2UserInfo
    fun supports(provider: OAuth2Provider): Boolean

}