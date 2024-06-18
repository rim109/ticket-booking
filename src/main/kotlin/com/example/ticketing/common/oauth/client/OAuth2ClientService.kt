package com.example.ticketing.common.oauth.client

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo
import org.springframework.stereotype.Component

@Component
class OAuth2ClientService(
    private val clientList: List<OAuth2Client>
) {

    fun generateLoginPageUrl(provider: OAuth2Provider): String {
        val client = this.selectClient(provider)
        return client.generateLoginPageUrl()
    }

    fun getUserInfo(provider: OAuth2Provider, authorizationCode: String): OAuth2UserInfo {
        val client = this.selectClient(provider)
        return client.getAccessToken(authorizationCode)
            .let { client.retrieveUserInfo(it) }
    }

    private fun selectClient(provider: OAuth2Provider): OAuth2Client {
        return clientList.find { it.supports(provider) }
            ?: throw RuntimeException("지원하지 않는 OAuth Provider 입니다!") // TODO : customException 생성
    }

}