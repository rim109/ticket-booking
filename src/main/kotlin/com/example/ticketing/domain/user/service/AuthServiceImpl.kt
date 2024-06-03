package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.request.LoginRequest
import com.example.ticketing.domain.user.dto.request.SignupRequest
import com.example.ticketing.domain.user.dto.response.LoginResponse
import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository
) : AuthService {
    override fun login(req: LoginRequest): LoginResponse {
        TODO("Not yet implemented")
    }

    override fun signup(req: SignupRequest): UserResponse {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }


}