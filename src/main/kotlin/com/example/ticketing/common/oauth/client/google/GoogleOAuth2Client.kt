package com.example.ticketing.common.oauth.client.google

import com.example.ticketing.common.oauth.client.OAuth2Client
import com.example.ticketing.common.oauth.client.google.dto.GoogleTokenResponse
import com.example.ticketing.common.oauth.client.google.dto.GoogleUserInfoResponse
import com.example.ticketing.common.oauth.provider.OAuth2Provider
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class GoogleOAuth2Client(
    private val restClient: RestClient,
    @Value("\${oauth2.google.client_id}") val clientId: String,
    @Value("\${oauth2.google.redirect_url}") val redirectUrl: String,
    @Value("\${oauth2.google.client_secret}") val clientSecret: String,
    @Value("\${oauth2.google.token_base_url}") val tokenBaseUrl: String,
    @Value("\${oauth2.google.auth_server_base_url}") val authServerBaseUrl: String,
    @Value("\${oauth2.google.resource_server_base_url}") val resourceServerBaseUrl: String
) : OAuth2Client {
    override fun generateLoginPageUrl(): String {
        return StringBuilder(authServerBaseUrl)
            .append("?response_type=").append("code")
            .append("&client_id=").append(clientId)
            .append("&redirect_uri=").append(redirectUrl)
            .append("&scope=")
            .append("https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email")
            .toString()
    }

    override fun getAccessToken(authorizationCode: String): String {
        val requestData = mutableMapOf(
            "grant_type" to "authorization_code",
            "client_id" to clientId,
            "client_secret" to clientSecret,
            "code" to authorizationCode,
            "redirect_uri" to redirectUrl
        )
        return restClient.post()
            .uri("$tokenBaseUrl/token")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(LinkedMultiValueMap<String, String>().apply { this.setAll(requestData) })
            .retrieve()
            .body<GoogleTokenResponse>()
            ?.accessToken
            ?: throw RuntimeException("UserInfo 조회 실패")
    }

    override fun retrieveUserInfo(accessToken: String): GoogleUserInfoResponse {
        return restClient.get()
            .uri("$resourceServerBaseUrl/userinfo")
            .header("Authorization", "Bearer $accessToken")
            .retrieve()
            .body<GoogleUserInfoResponse>()
            ?: throw RuntimeException("UserInfo 조회 실패")
    }

    override fun supports(provider: OAuth2Provider): Boolean {
        return provider == OAuth2Provider.GOOGLE
    }
}