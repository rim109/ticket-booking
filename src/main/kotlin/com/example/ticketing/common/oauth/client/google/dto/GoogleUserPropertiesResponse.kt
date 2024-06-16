package com.example.ticketing.common.oauth.client.google.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GoogleUserPropertiesResponse(
    val email: String,
    val nickname: String
)
