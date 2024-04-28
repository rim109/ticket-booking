package com.example.ticketing.domain.ticket.service

import com.example.ticketing.domain.ticket.dto.request.TicketRequest
import com.example.ticketing.domain.ticket.dto.response.TicketResponse
import com.example.ticketing.domain.ticket.model.Ticket
import com.example.ticketing.domain.ticket.repository.TicketRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TicketServiceImpl(
    private val ticketRepository: TicketRepository
) : TicketService {
    override fun createTicket(req: TicketRequest): TicketResponse {
        val ticket = ticketRepository.save(
            Ticket(
                date = req.date,
                times = req.times,
                seats = req.seats
            )
        )
        return TicketResponse.from(ticket)
    }

    override fun getTicket(ticketId: Long): TicketResponse {
        val ticket = ticketRepository.findByIdOrNull(ticketId) ?: TODO()
        return TicketResponse.from(ticket)
    }

    override fun updateTicket(ticketId: Long, req: TicketRequest): TicketResponse {
        val ticket = ticketRepository.findByIdOrNull(ticketId) ?: TODO()
        ticket.date = req.date
        ticket.times = req.times
        ticket.seats = req.seats

        return TicketResponse.from(ticket)
    }

    override fun deleteTicket(ticketId: Long) {
        val ticket = ticketRepository.findByIdOrNull(ticketId) ?: TODO()
        ticketRepository.delete(ticket)
    }
}