package com.example.ticketing.domain.inform.service

import com.example.ticketing.domain.inform.dto.InformDto
import com.example.ticketing.domain.inform.dto.GetInformDto

interface InformService {

    // 공지 단건 조회
    fun getInform(informId: Long): GetInformDto

    // 공지 전체 조회
    fun getAllInform(): GetInformDto

    // 공지 생성
    fun createInform(): InformDto

    // 공지 수정
    fun updateInform(informId: Long): InformDto

    // 공지 삭제
    fun deleteInform(informId: Long)
}