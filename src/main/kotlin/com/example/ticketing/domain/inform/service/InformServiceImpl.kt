package com.example.ticketing.domain.inform.service

import com.example.ticketing.domain.inform.dto.GetInformDto
import com.example.ticketing.domain.inform.dto.InformDto
import com.example.ticketing.domain.inform.model.Inform
import com.example.ticketing.domain.inform.repository.InformRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class InformServiceImpl(
    private val informRepository: InformRepository
) : InformService {
    override fun getInform(informId: Long): GetInformDto {
        val inform = informRepository.findByIdOrNull(informId) ?: TODO()
        return GetInformDto.from(inform)
    }

    override fun getAllInform(): List<GetInformDto> {
        return informRepository.findAll().map { GetInformDto.from(it) }
    }

    override fun createInform(req: InformDto): InformDto {
        val inform = informRepository.save(
            Inform(
                title = req.title,
                content = req.content,
                imageUrl = req.imageUrl,
                price = req.price,
                address = req.address,
                period = req.period,
                totalTime = req.totalTime,
                isDeleted = false
            )
        )
        return InformDto.from(inform)
    }

    override fun updateInform(informId: Long, req: InformDto): InformDto {
        val inform = informRepository.findByIdOrNull(informId) ?: TODO()

        inform.title = req.title
        inform.content = req.content
        inform.imageUrl = req.imageUrl
        inform.price = req.price
        inform.address = req.address
        inform.period = req.period
        inform.totalTime = req.totalTime

        return InformDto.from(inform)
    }

    override fun deleteInform(informId: Long) {
        val inform = informRepository.findByIdOrNull(informId) ?: TODO()
        informRepository.delete(inform)
    }
}