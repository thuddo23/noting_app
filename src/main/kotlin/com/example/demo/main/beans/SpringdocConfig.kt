package com.example.demo.main.beans

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition
@Configuration
class SpringdocConfig {

    @Bean
    fun baseOpenAPI(): OpenAPI = OpenAPI().apply {
        info = Info()
            .title("Teddy Spring Doc")
            .version("1.0.0")
            .description("Spring doc description!")
    }
}