package com.example.ticketing.domain.category.service

import com.example.ticketing.domain.category.dto.CategoryDto
import com.example.ticketing.domain.category.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
): CategoryService {
    override fun getAllCategory(): CategoryDto {
        TODO("Not yet implemented")
    }

    override fun getCategory(categoryId: Long): CategoryDto {
        TODO("Not yet implemented")
    }

    override fun createCategory(): CategoryDto {
        TODO("Not yet implemented")
    }

    override fun deleteCategory(categoryId: Long) {
        TODO("Not yet implemented")
    }
}