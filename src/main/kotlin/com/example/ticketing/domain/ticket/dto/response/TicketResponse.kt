package com.example.ticketing.domain.ticket.dto.response

import com.example.ticketing.domain.ticket.model.Ticket

data class TicketResponse(
    val id: Long
) {
    companion object {
        fun from(ticket: Ticket): TicketResponse {
            return TicketResponse(
                id = ticket.id!!
            )
        }
    }
}

