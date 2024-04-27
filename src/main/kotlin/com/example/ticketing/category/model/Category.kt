package com.example.ticketing.category.model

import jakarta.persistence.*

@Entity
@Table(name= "category")
class Category(
    @Column
    val name: String,

    @Column
    val info: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}