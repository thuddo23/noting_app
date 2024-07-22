package com.example.demo.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.*

@Entity
data class User(
    @Id
    @GeneratedValue
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: Date,
    val updatedAt: Date?
)