package com.example.ticketing.domain.user.dto.request

data class SignupRequest(
    val name: String,
    val nickname: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String
)
