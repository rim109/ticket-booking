package com.example.ticketing.domain.user.dto.request

import com.example.ticketing.common.oauth.provider.OAuth2Provider

open class OAuth2UserInfo (
    val provider: OAuth2Provider,
    val id: String,
    val nickname: String,
    val email: String,
    val profileImage: String
)