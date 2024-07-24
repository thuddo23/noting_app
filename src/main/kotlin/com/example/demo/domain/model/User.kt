package com.example.demo.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
data class User(
    @Id
    @SequenceGenerator(
        name = "user_id_sequence",
        sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_sequence"
    )
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: Date,
    val updatedAt: Date?
)