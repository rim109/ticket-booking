package com.example.ticketing.domain.user.service

import com.example.ticketing.common.oauth.provider.OAuth2Provider
import com.example.ticketing.domain.user.dto.request.OAuth2UserInfo
import com.example.ticketing.domain.user.model.SocialMember
import com.example.ticketing.domain.user.repository.SocialUserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SocialUserService(
    private val socialUserRepository: SocialUserRepository
) {
    @Transactional
    fun registerIfAbsent(oAuth2UserInfo: OAuth2UserInfo): SocialMember {
        return if (!socialUserRepository.existsByProviderAndProviderId(oAuth2UserInfo.provider, oAuth2UserInfo.id)) {
            val socialUser = when(oAuth2UserInfo.provider){
                OAuth2Provider.KAKAO -> SocialMember.ofKakao(oAuth2UserInfo.id.toLong(), oAuth2UserInfo.nickname, oAuth2UserInfo.email, oAuth2UserInfo.profileImage)
                OAuth2Provider.GOOGLE -> SocialMember.ofGoogle(oAuth2UserInfo.id, oAuth2UserInfo.nickname, oAuth2UserInfo.email,oAuth2UserInfo.profileImage)
            }
            socialUserRepository.save(socialUser)
        } else {
            socialUserRepository.findByProviderAndProviderId(oAuth2UserInfo.provider, oAuth2UserInfo.id)
        }
    }
}