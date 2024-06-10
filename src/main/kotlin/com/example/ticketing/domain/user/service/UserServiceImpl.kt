package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.request.UpdateUserRequest
import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun getUser(userId: Long): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: TODO()
        return UserResponse.from(user)
    }


    @Transactional
    override fun updateUser(userId: Long, req: UpdateUserRequest): UserResponse {
        val user = userRepository.findByIdOrNull(userId) ?: TODO()
        user.nickname = req.nickname
        user.password = passwordEncoder.encode(req.password)
        user.phoneNumber = req.phoneNumber
        user.address = req.address
        return UserResponse.from(user)
    }

    @Transactional
    override fun deleteUser(userId: Long) {
        val user = userRepository.findByIdOrNull(userId) ?: TODO()
        userRepository.delete(user)
    }
}