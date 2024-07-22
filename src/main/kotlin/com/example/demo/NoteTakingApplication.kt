package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import springfox.documentation.swagger2.annotations.EnableSwagger2

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class NoteTakingApplication

fun main(args: Array<String>) {
	runApplication<NoteTakingApplication>(*args)
}
