package com.example.demo.domain.dto

import com.example.demo.domain.model.User
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.validation.constraints.Size
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("name", "email", "password")
data class UserDTO(
    @Size(min = 2)
    val name: String,
    val email: String,
    val password: String
) {
    fun convertToEntity() =
        User(
            name = this.name,
            email = this.email,
            password = this.password,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
}
