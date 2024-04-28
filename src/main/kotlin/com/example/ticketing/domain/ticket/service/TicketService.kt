package com.example.ticketing.domain.ticket.service

import com.example.ticketing.domain.ticket.dto.request.TicketRequest
import com.example.ticketing.domain.ticket.dto.response.TicketResponse

interface TicketService {

    // 티켓 생성
    fun createTicket(req: TicketRequest): TicketResponse

    // 티켓 단건 조회
    fun getTicket(ticketId: Long): TicketResponse

    // 티켓 수정
    fun updateTicket(ticketId: Long, req: TicketRequest): TicketResponse

    // 타켓 삭제
    fun deleteTicket(ticketId: Long)
}