package com.example.ticketing.common.oauth.client.kakao.dto

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class KakaoUserInfoResponse(
    val id: Long,
    val properties: KakaoUserPropertiesResponse
){
    val nickname: String
        get() = properties.nickname
    val email: String
        get() = properties.email
    val provider: OAuth2Provider
        get() = OAuth2Provider.KAKAO
}
