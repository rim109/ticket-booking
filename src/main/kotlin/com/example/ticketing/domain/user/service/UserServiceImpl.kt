package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun getUser(userId: Long): UserResponse {
        TODO("Not yet implemented")
    }

    override fun updateUser(userId: Long): UserResponse {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: Long) {
        TODO("Not yet implemented")
    }
}