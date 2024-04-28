package com.example.ticketing.domain.ticket.dto.request

data class TicketRequest (
    val date: String,
    val times: String,
    val seats: Int
)