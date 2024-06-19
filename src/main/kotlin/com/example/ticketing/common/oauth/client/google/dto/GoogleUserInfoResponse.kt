package com.example.ticketing.common.oauth.client.google.dto

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class GoogleUserInfoResponse(
    id: String,
    name: String,

    @JsonProperty
    email: String

) : OAuth2UserInfo(
    provider = OAuth2Provider.GOOGLE,
    id = id,
    nickname = name,
    email = email
)

