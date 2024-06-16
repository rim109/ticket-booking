package com.example.ticketing.domain.user.service

import com.example.ticketing.common.security.jwt.JwtPlugin
import com.example.ticketing.domain.user.dto.request.LoginRequest
import com.example.ticketing.domain.user.dto.request.SignupRequest
import com.example.ticketing.domain.user.dto.response.LoginResponse
import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.model.User
import com.example.ticketing.domain.user.model.UserRole
import com.example.ticketing.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val jwtPlugin: JwtPlugin
) : AuthService {
    override fun login(req: LoginRequest): LoginResponse {
        val user = userRepository.findByEmail(req.email) ?: TODO()
        return LoginResponse(
            token = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                email = user.email,
                role = UserRole.USER.toString()
            )
        )
    }

    override fun signup(req: SignupRequest): UserResponse {
        val user = userRepository.save(
            User(
                name = req.name,
                nickname = req.nickname,
                email = req.email,
                password = req.password,
                address = req.address,
                phoneNumber = req.phoneNumber
            )
        )
        return UserResponse.from(user)
    }

    override fun logout() {
        TODO("Not yet implemented")
    }


}