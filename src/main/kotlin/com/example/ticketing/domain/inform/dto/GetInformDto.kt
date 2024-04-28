package com.example.ticketing.domain.inform.dto

import com.example.ticketing.domain.inform.model.Inform

data class GetInformDto(
    val id: Long
){
    companion object{
        fun from(inform: Inform): GetInformDto {
            return GetInformDto(
                id = inform.id!!
            )
        }
    }
}
