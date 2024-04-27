package com.example.ticketing.domain.ticket.controller

import com.example.ticketing.domain.ticket.dto.response.TicketResponse
import com.example.ticketing.domain.ticket.service.TicketService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tickets")
class TicketController(
    private val ticketService: TicketService
) {

    @GetMapping("/{ticketId}")
    fun getTicket(
        @PathVariable ticketId: Long
    ): ResponseEntity<TicketResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicket(ticketId))
    }

    @PostMapping
    fun createTicket(): ResponseEntity<TicketResponse>{
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket())
    }

    @PatchMapping("/{ticketId}")
    fun updateTicket(
        @PathVariable ticketId: Long
    ): ResponseEntity<TicketResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.updateTicket(ticketId))
    }

    @DeleteMapping("/{ticketId}")
    fun deleteTicket(
        @PathVariable ticketId: Long
    ): ResponseEntity<TicketResponse> {
        ticketService.deleteTicket(ticketId)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }
}