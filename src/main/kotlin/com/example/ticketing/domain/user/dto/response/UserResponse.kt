package com.example.ticketing.domain.user.dto.response

import com.example.ticketing.domain.ticket.dto.response.TicketResponse
import com.example.ticketing.domain.user.model.User

data class UserResponse(
    val id: Long
){
    companion object {
        fun from(user: User): UserResponse {
            return UserResponse(
                id = user.id!!
            )
        }
    }
}
