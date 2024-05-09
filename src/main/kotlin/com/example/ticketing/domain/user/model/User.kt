package com.example.ticketing.domain.user.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(

    @Column(name = "name")
    var name: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "phoneNumber")
    var phoneNumber: String,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}