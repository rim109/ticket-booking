package com.example.ticketing.domain.inform.service

import com.example.ticketing.domain.inform.dto.GetInformDto
import com.example.ticketing.domain.inform.dto.InformDto
import com.example.ticketing.domain.inform.repository.InformRepository
import org.springframework.stereotype.Service

@Service
class InformServiceImpl(
    private val informRepository: InformRepository
) : InformService {
    override fun getInform(informId: Long): GetInformDto {
        TODO("Not yet implemented")
    }

    override fun getAllInform(): GetInformDto {
        TODO("Not yet implemented")
    }

    override fun createInform(): InformDto {
        TODO("Not yet implemented")
    }

    override fun updateInform(informId: Long): InformDto {
        TODO("Not yet implemented")
    }

    override fun deleteInform(informId: Long) {
        TODO("Not yet implemented")
    }
}