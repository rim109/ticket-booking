package com.example.ticketing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
class TicketingApplication

fun main(args: Array<String>) {
	runApplication<TicketingApplication>(*args)
}
