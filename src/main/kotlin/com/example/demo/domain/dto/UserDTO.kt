package com.example.demo.domain.dto

import com.example.demo.domain.model.User
import jakarta.validation.constraints.Size
import java.util.*

data class UserDTO(
    @Size(min = 2)
    val name: String,
    val email: String,
    val password: String
) {
    fun convertToEntity() = User(
        name = this.name,
        email = this.email,
        password = this.password,
        createdAt = Date(),
        updatedAt = Date()
    )
}