//package com.example.demo.main.controller.configuration
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.service.ApiInfo
//import springfox.documentation.service.ApiKey
//import springfox.documentation.service.Contact
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket
//import java.util.*
//
//@Configuration
//class SwaggerConfig {
//    @Bean
//    fun swaggerApi(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//    }
//
//    /*private fun apiKey(): ApiKey {
//        return ApiKey("JWT", AUTHORIZATION_HEADER, "header")
//    }*/
//
//    private fun apiInfo(): ApiInfo {
//        return ApiInfo(
//            "Spring Boot Blog REST APIs",
//            "Spring Boot Blog REST API Documentation",
//            "1",
//            "Terms of service",
//            Contact("Ramesh Fadatare", "www.javaguides.net", "thuandohusk65@gmail.com"),
//            "License of API",
//            "API license URL",
//            Collections.emptyList()
//        )
//    }
//
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2)
//            .apiInfo(apiInfo())
////            .securityContexts(Arrays.asList(securityContext()))
////            .securitySchemes(Arrays.asList(apiKey()))
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//    }
//
//    /*private fun securityContext(): SecurityContext {
//        return SecurityContext.builder().securityReferences(defaultAuth()).build()
//    }*/
//
//    /*private fun defaultAuth(): List<SecurityReference> {
//        val authorizationScope: AuthorizationScope = AuthorizationScope("global", "accessEverything")
//        val authorizationScopes: Array<AuthorizationScope?> = arrayOfNulls<AuthorizationScope>(1)
//        authorizationScopes[0] = authorizationScope
//        return Arrays.asList(SecurityReference("JWT", authorizationScopes))
//    }*/
//
//    companion object {
//        const val AUTHORIZATION_HEADER: String = "Authorization"
//    }
//}
