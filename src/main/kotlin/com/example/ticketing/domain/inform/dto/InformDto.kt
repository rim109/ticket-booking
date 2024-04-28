package com.example.ticketing.domain.inform.dto

import com.example.ticketing.domain.inform.model.Inform

data class InformDto(
    val title: String,
    val content: String,
    val imageUrl: String,
    val price: String,
    val address: String,
    val period: String,
    val totalTime: String
) {
    companion object {
        fun from(inform: Inform): InformDto {
            return InformDto(
                title = inform.title,
                content = inform.content,
                imageUrl = inform.imageUrl,
                price = inform.price,
                address = inform.address,
                period = inform.period,
                totalTime = inform.totalTime
            )
        }
    }
}
