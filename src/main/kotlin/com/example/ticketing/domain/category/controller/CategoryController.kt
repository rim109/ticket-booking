package com.example.ticketing.domain.category.controller

import com.example.ticketing.domain.category.dto.CategoryDto
import com.example.ticketing.domain.category.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping
    fun getAllCategory(): ResponseEntity<List<CategoryDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategory())
    }

    @GetMapping("/{categoryId}")
    fun getCategory(
        @PathVariable categoryId: Long
    ): ResponseEntity<CategoryDto> {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategory(categoryId))
    }

    @PostMapping
    fun createCategory(req: CategoryDto): ResponseEntity<CategoryDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(req))
    }

    @DeleteMapping("/{categoryId}")
    fun deleteCategory(
        @PathVariable categoryId: Long
    ): ResponseEntity<Unit> {
        categoryService.deleteCategory(categoryId)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

}