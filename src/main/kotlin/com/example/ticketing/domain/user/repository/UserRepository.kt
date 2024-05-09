package com.example.ticketing.domain.user.repository

import com.example.ticketing.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
}