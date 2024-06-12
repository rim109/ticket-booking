package com.example.ticketing.common.oauth.client.google.dto

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GoogleUserInfoResponse(
    val id: Long,
    val properties: GoogleUserPropertiesResponse
){
    val nickname: String
        get() = properties.nickname
    val email: String
        get() = properties.email
    val provider: OAuth2Provider
        get() = OAuth2Provider.GOOGLE
}
