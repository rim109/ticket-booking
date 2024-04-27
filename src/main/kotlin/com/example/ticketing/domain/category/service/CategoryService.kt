package com.example.ticketing.domain.category.service

import com.example.ticketing.domain.category.dto.CategoryDto

interface CategoryService {

    // 카테고리 전체 조회
    fun getAllCategory(): CategoryDto

    // 카테고리 단건 조회
    fun getCategory(categoryId: Long): CategoryDto

    // 카테고리 생성
    fun createCategory(): CategoryDto

    //카테고리 삭제
    fun deleteCategory(categoryId: Long)

}
