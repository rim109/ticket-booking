package com.example.ticketing.domain.category.model

import jakarta.persistence.*

@Entity
@Table(name = "category")
class Category(
    @Column(name = "name")
    val name: String,

    @Column(name = "info")
    val info: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}