package com.example.ticketing.domain.user.controller

import com.example.ticketing.domain.user.dto.request.UpdateUserRequest
import com.example.ticketing.domain.user.dto.response.UserResponse
import com.example.ticketing.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{userId}")
    fun getUser(
        @PathVariable userId: Long
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId))
    }

    @PatchMapping("/{userId}")
    fun updateUser(
        @PathVariable userId: Long,
        @RequestBody req: UpdateUserRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, req))
    }

    @DeleteMapping("/{userId}")
    fun deleteUser(
        @PathVariable userId: Long
    ): ResponseEntity<Unit> {
        userService.deleteUser(userId)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}