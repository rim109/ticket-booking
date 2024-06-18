package com.example.ticketing.common.oauth.client.kakao

import com.example.ticketing.common.oauth.client.OAuth2Client
import com.example.ticketing.common.oauth.client.kakao.dto.KakaoTokenResponse
import com.example.ticketing.common.oauth.client.kakao.dto.KakaoUserInfoResponse
import com.example.ticketing.common.oauth.provider.OAuth2Provider
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class KakaoOAuth2Client(
    private val restClient: RestClient,
    @Value("\${oauth2.kakao.client_id}") val clientId: String,
    @Value("\${oauth2.kakao.redirect_url}") val redirectUrl: String,
    @Value("\${oauth2.kakao.auth_server_base_url}") val authServerBaseUrl: String,
    @Value("\${oauth2.kakao.resource_server_base_url}") val resourceServerBaseUrl: String,

    ) : OAuth2Client {
    override fun generateLoginPageUrl(): String {
        return StringBuilder(authServerBaseUrl)
            .append("/oauth/authorize")
            .append("?client_id=").append(clientId)
            .append("&redirect-uri=").append(redirectUrl)
            .append("&response_type=").append("code")
            .toString()
    }

    override fun getAccessToken(authorizationCode: String): String {
        val requestData = mutableMapOf(
            "grant_type" to "authorization_code",
            "client_id" to clientId,
            "code" to authorizationCode
        )
        return restClient.post()
            .uri("$authServerBaseUrl/oauth/token")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(LinkedMultiValueMap<String, String>().apply { this.setAll(requestData) })
            .retrieve()
            .body<KakaoTokenResponse>()
            ?.accessToken
            ?: throw RuntimeException("UserInfo 조회 실패")
    }

    override fun retrieveUserInfo(accessToken: String): KakaoUserInfoResponse {
        return restClient.get()
            .uri("$resourceServerBaseUrl/user/me")
            .header("Authorziation", "Bearer $accessToken")
            .retrieve()
            .body<KakaoUserInfoResponse>()
            ?: throw RuntimeException("UserInfo 조회 실패")
    }

    override fun supports(provider: OAuth2Provider): Boolean {
        return provider == OAuth2Provider.KAKAO
    }

}