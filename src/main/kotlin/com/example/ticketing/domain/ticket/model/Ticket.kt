package com.example.ticketing.domain.ticket.model

import com.example.ticketing.common.model.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete

@Entity
@SQLDelete(sql = "UPDATE ticket SET is_deleted = true WHERE id = ?")
@Table(name = "ticket")
class Ticket(
    @Column(name = "date")
    var date: String,

    @Column(name = "times")
    var times: String,

    @Column(name = "seats")
    var seats: Int,

    @Column(name = "is_deleted")
    var isDeleted: Boolean = false

): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}