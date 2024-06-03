package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.response.UserResponse

interface UserService {

    // 프로필 조회
    fun getUser(userId: Long): UserResponse

    // 프로필 수정
    fun updateUser(userId: Long): UserResponse

    // 탈퇴하기
    fun deleteUser(userId: Long)
}