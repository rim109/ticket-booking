package com.example.ticketing.domain.category.service

import com.example.ticketing.domain.category.dto.CategoryDto
import com.example.ticketing.domain.category.model.Category
import com.example.ticketing.domain.category.repository.CategoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
): CategoryService {
    override fun getAllCategory(): List<CategoryDto> {
        return categoryRepository.findAll().map { CategoryDto.from(it) }
    }

    override fun getCategory(categoryId: Long): CategoryDto {
        val category = categoryRepository.findByIdOrNull(categoryId) ?: TODO()
        return CategoryDto.from(category)
    }

    override fun createCategory(req: CategoryDto): CategoryDto {
        val category = categoryRepository.save(
            Category(
                name = req.name
            )
        )
        return CategoryDto.from(category)
    }

    override fun deleteCategory(categoryId: Long) {
        val category = categoryRepository.findByIdOrNull(categoryId) ?: TODO()
        categoryRepository.delete(category)
    }
}