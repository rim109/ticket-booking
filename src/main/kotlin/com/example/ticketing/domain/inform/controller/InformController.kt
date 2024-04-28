package com.example.ticketing.domain.inform.controller

import com.example.ticketing.domain.inform.dto.GetInformDto
import com.example.ticketing.domain.inform.dto.InformDto
import com.example.ticketing.domain.inform.service.InformService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/informs")
@RestController
class InformController(
    private val informService: InformService
) {

    @GetMapping
    fun getAllInform(): ResponseEntity<List<GetInformDto>> {
        return ResponseEntity.status(HttpStatus.OK).body(informService.getAllInform())
    }

    @GetMapping("/{informId}")
    fun getInform(
        @PathVariable informId: Long
    ): ResponseEntity<GetInformDto> {
        return ResponseEntity.status(HttpStatus.OK).body(informService.getInform(informId))
    }

    @PostMapping
    fun createInform(@RequestBody req: InformDto): ResponseEntity<InformDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(informService.createInform(req))
    }

    @PatchMapping("/{informId}")
    fun updateInform(
        @PathVariable informId: Long,
        @RequestBody req: InformDto
    ): ResponseEntity<InformDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(informService.updateInform(informId, req))
    }

    @DeleteMapping("/{informId}")
    fun deleteInform(
        @PathVariable informId: Long
    ): ResponseEntity<Unit> {
        informService.deleteInform(informId)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

}