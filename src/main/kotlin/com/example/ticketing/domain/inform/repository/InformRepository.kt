package com.example.ticketing.domain.inform.repository

import com.example.ticketing.domain.inform.model.Inform
import org.springframework.data.jpa.repository.JpaRepository

interface InformRepository : JpaRepository<Inform, Long> {
}