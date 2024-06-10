package com.example.ticketing.common.oauth.client.kakao.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class KakaoUserInfoResponse(
    val id: Long,
    val properties: KakaoUserPropertiesResponse
){
    val nickname: String
        get() = properties.nickname
}
