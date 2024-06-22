package com.example.ticketing.domain.user.model

import com.example.ticketing.common.model.BaseTimeEntity
import com.example.ticketing.common.oauth.provider.OAuth2Provider
import jakarta.persistence.*

@Entity
@Table(name = "social_member")
class SocialMember(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    val provider: OAuth2Provider,
    val providerId: String,
    val nickname: String,
    val email: String,
    val profileImage: String,

    @Enumerated(EnumType.STRING)
    val role: UserRole = UserRole.USER


) : BaseTimeEntity() {
    companion object {
        fun ofKakao(id: Long, nickname: String, email: String, profileImage: String): SocialMember {
            return SocialMember(
                provider = OAuth2Provider.KAKAO,
                providerId = id.toString(),
                nickname = nickname,
                email = email,
                profileImage = profileImage
            )
        }

        fun ofGoogle(id: String, nickname: String, email: String, profileImage: String): SocialMember {
            return SocialMember(
                provider = OAuth2Provider.GOOGLE,
                providerId = id,
                nickname = nickname,
                email = email,
                profileImage = profileImage
            )
        }
    }
}