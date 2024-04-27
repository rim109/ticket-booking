package com.example.ticketing.category.repository

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Locale.Category

interface CategoryRepository:JpaRepository<Category,Long> {
}