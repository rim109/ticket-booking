package com.example.ticketing.domain.user.service

import com.example.ticketing.domain.user.dto.request.LoginRequest
import com.example.ticketing.domain.user.dto.request.SignupRequest
import com.example.ticketing.domain.user.dto.response.LoginResponse
import com.example.ticketing.domain.user.dto.response.UserResponse


interface AuthService {

    // 로그인
    fun login(req: LoginRequest): LoginResponse

    // 회원가입
    fun signup(req: SignupRequest): UserResponse

    // 로그아웃 - 아직 안해본 것으로 차차 추가할 예정 임시로 틀만 작성함!
    fun logout()
}