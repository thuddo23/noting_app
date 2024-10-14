package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class NoteTakingApplication

fun main(args: Array<String>) {
	runApplication<NoteTakingApplication>(*args)
}
