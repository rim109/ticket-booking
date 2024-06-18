package com.example.ticketing.common.oauth.client.google.dto

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class GoogleUserInfoResponse(
    id: Long,
    properties: GoogleUserPropertiesResponse

) : OAuth2UserInfo(
    provider = OAuth2Provider.GOOGLE,
    id = id.toString(),
    nickname = properties.nickname,
    email = properties.email,
    profileImage = String() // 수정 예정
)

