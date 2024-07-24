package com.example.demo.main.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.Date

@ControllerAdvice
class GlobalExceptionHandler {

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException,
        webRequest: WebRequest
    ): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            timestamp = Date(),
            message = exception.message!!,
            details = webRequest.getDescription(false),
        )
        return ResponseEntity(
            errorDetails,
            HttpStatus.NOT_FOUND
        )
    }
    @ExceptionHandler(InvalidUpdateResourceException::class)
    fun handleInvalidUpdateResourceException(
        exception: InvalidUpdateResourceException,
        webRequest: WebRequest
    ): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            timestamp = Date(),
            message = exception.message!!,
            details = webRequest.getDescription(false),
        )
        return ResponseEntity(
            errorDetails,
            HttpStatus.NOT_FOUND
        )
    }

    /*@ExceptionHandler(Exception::class)
    fun handleCommonException(
        exception: Exception,
        webRequest: WebRequest
    ): ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(
            timestamp = Date(),
            message = exception.message!!,
            details = webRequest.getDescription(false),
        )
        return ResponseEntity(
            errorDetails,
            HttpStatus.NOT_FOUND
        )
    }*/
}