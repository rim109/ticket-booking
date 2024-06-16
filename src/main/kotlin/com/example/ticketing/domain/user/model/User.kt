package com.example.ticketing.domain.user.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Table(name = "users")
class User(

    @Column(name = "name", nullable = false, length = 8)
    var name: String,

    @Column(name = "email", nullable = false, length = 30)
    var email: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @Column(name = "nickname", length = 20)
    var nickname: String,

    @Column(name = "address", columnDefinition = "TEXT")
    var address: String,

    @Column(name = "phoneNumber", length = 13)
    var phoneNumber: String,

    @Enumerated(EnumType.STRING)
    val role: UserRole = UserRole.USER

) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}