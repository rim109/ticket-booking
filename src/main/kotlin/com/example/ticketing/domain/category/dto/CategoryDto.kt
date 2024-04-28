package com.example.ticketing.domain.category.dto

import com.example.ticketing.domain.category.model.Category


data class CategoryDto(
    val name: String
) {
    companion object {
        fun from(category: Category): CategoryDto {
            return CategoryDto(
                name = category.name
            )
        }
    }
}


