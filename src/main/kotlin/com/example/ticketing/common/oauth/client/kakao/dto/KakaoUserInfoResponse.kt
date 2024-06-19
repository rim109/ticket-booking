package com.example.ticketing.common.oauth.client.kakao.dto

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class KakaoUserInfoResponse(
    id: Long,
    properties: KakaoUserPropertiesResponse,
    kakaoAccount: KakaoUserAccountResponse

) : OAuth2UserInfo(
    provider = OAuth2Provider.KAKAO,
    id = id.toString(),
    nickname = properties.nickname,
    email = kakaoAccount.email
)
