package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.request.LoginRequest
import com.example.ticketing.domain.user.dto.request.SignupRequest
import com.example.ticketing.domain.user.dto.response.LoginResponse
import com.example.ticketing.domain.user.dto.response.UserResponse


interface AuthService {

    fun login(req: LoginRequest): LoginResponse

    fun signup(req: SignupRequest): UserResponse

    fun logout()
}