package com.example.ticketing.domain.inform.model

import jakarta.persistence.*

@Entity
@Table(name = "inform")
class Inform(

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @Column(name = "image_Url")
    val imageUrl: String,

    @Column(name = "price")
    val price: String,

    @Column(name = "address")
    val address: String,

    @Column(name = "period")
    val period: String,

    @Column(name = "totalTime")
    val totalTime: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

}