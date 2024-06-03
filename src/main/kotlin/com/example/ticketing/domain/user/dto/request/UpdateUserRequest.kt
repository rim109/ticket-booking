package com.example.ticketing.domain.user.dto.request

data class UpdateUserRequest(
    val nickname: String,
    val password: String,
    val phoneNumber: String,
    val address: String
)
