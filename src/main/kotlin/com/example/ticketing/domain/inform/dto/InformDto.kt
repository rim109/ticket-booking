package com.example.ticketing.domain.inform.dto

data class InformDto(
    val title: String,
    val content: String,
    val imageUrl: String,
    val price: String,
    val address: String,
    val period: String,
    val totalTime: String
) {
//    companion object
//    fun from()
}
