package com.example.ticketing.domain.ticket.service

import com.example.ticketing.domain.ticket.dto.response.TicketResponse
import com.example.ticketing.domain.ticket.repository.TicketRepository
import org.springframework.stereotype.Service

@Service
class TicketServiceImpl(
    private val ticketRepository: TicketRepository
) : TicketService {
    override fun createTicket(): TicketResponse {
        TODO("Not yet implemented")
    }

    override fun getTicket(ticketId: Long): TicketResponse {
        TODO("Not yet implemented")
    }

    override fun updateTicket(ticketId: Long): TicketResponse {
        TODO("Not yet implemented")
    }

    override fun deleteTicket(ticketId: Long) {
        TODO("Not yet implemented")
    }
}