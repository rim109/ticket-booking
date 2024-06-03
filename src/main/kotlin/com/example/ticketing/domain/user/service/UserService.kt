package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.response.UserResponse

interface UserService {

    fun getUser(userId: Long): UserResponse

    fun updateUser(userId: Long): UserResponse

    fun deleteUser(userId: Long)
}