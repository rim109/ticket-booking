package com.example.ticketing.inform.controller

import com.example.ticketing.inform.dto.GetInformDto
import com.example.ticketing.inform.dto.InformDto
import com.example.ticketing.inform.service.InformService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/informs")
@RestController
class InformController(
    private val informService: InformService
) {

    @GetMapping
    fun getAllInform(): ResponseEntity<GetInformDto> {
        return ResponseEntity.status(HttpStatus.OK).body(informService.getAllInform())
    }

    @GetMapping("/{informId}")
    fun getInform(
        @PathVariable informId: Long
    ): ResponseEntity<GetInformDto> {
        return ResponseEntity.status(HttpStatus.OK).body(informService.getInform(informId))
    }

    @PostMapping
    fun createInform(): ResponseEntity<InformDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(informService.createInform())
    }

    @PatchMapping("/{informId}")
    fun updateInform(
        @PathVariable informId: Long
    ): ResponseEntity<InformDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(informService.updateInform(informId))
    }

    @DeleteMapping("/{informId}")
    fun deleteInform(
        @PathVariable informId: Long
    ): ResponseEntity<Unit> {
        informService.deleteInform(informId)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

}