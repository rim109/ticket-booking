package com.example.ticketing.domain.ticket.repository

import com.example.ticketing.domain.ticket.model.Ticket
import org.springframework.data.jpa.repository.JpaRepository

interface TicketRepository : JpaRepository<Ticket, Long> {
}