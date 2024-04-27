package com.example.ticketing.domain.ticket.model

import jakarta.persistence.*

@Entity
@Table(name = "ticket")
class Ticket(
    @Column(name = "date")
    val date: String,

    @Column(name = "times")
    val times: String,

    @Column(name = "seats")
    val seats: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}