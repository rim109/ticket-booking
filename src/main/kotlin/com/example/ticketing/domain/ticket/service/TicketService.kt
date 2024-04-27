package com.example.ticketing.domain.ticket.service

import com.example.ticketing.domain.ticket.dto.response.TicketResponse

interface TicketService {

    // 티켓 생성
    fun createTicket(): TicketResponse

    // 티켓 단건 조회
    fun getTicket(ticketId: Long): TicketResponse

    // 티켓 수정
    fun updateTicket(ticketId: Long): TicketResponse

    // 타켓 삭제
    fun deleteTicket(ticketId: Long)
}