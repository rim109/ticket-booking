package com.example.ticketing.domain.user.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import com.example.ticketing.domain.user.dto.request.LoginRequest
import com.example.ticketing.domain.user.dto.request.SignupRequest
import com.example.ticketing.domain.user.dto.response.LoginResponse
import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.service.AuthService
import com.example.ticketing.domain.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(
        @RequestBody req: LoginRequest
    ): ResponseEntity<LoginResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(req))
    }

    @PostMapping("/signup")
    fun signup(
        @RequestBody req: SignupRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(authService.signup(req))
    }

    @GetMapping("/logout")
    fun logout() {
        TODO()
    }

}