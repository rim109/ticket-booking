package com.example.ticketing.domain.user.dto.request

data class SignupRequest(
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String
)
