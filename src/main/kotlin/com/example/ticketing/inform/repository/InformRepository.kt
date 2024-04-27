package com.example.ticketing.inform.repository

import com.example.ticketing.inform.model.Inform
import org.springframework.data.jpa.repository.JpaRepository

interface InformRepository : JpaRepository<Inform, Long> {
}