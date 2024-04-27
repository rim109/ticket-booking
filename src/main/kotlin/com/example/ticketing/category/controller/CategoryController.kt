package com.example.ticketing.category.controller

import com.example.ticketing.category.dto.CategoryDto
import com.example.ticketing.category.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(
    private val categoryService: CategoryService
) {

    @GetMapping("/category")
    fun getAllCategory(): ResponseEntity<CategoryDto> {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategory())
    }

    @GetMapping("/category/{categoryId}")
    fun getCategory(
        @PathVariable categoryId: Long
    ): ResponseEntity<CategoryDto> {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategory(categoryId))
    }

    @PostMapping("/category")
    fun createCategory(): ResponseEntity<CategoryDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory())
    }

    @DeleteMapping("/category/{categoryId}")
    fun deleteCategory(
        @PathVariable categoryId: Long
    ): ResponseEntity<Unit> {
        categoryService.deleteCategory(categoryId)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

}