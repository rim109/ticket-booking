package com.example.ticketing.domain.user.repository

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.model.SocialMember
import org.springframework.data.jpa.repository.JpaRepository

interface SocialUserRepository : JpaRepository<SocialMember, Long> {

    fun existsByProviderAndProviderId(provider: OAuth2Provider, providerId: String): Boolean
    fun findByProviderAndProviderId(provider: OAuth2Provider, providerId: String): SocialMember
}