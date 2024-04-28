package com.example.ticketing.domain.category.repository

import com.example.ticketing.domain.category.model.Category
import org.springframework.data.jpa.repository.JpaRepository


interface CategoryRepository:JpaRepository<Category,Long> {
}