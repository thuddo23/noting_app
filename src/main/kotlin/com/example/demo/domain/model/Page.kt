package com.example.demo.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
data class Page(
    @Id
    @SequenceGenerator(
        name = "page_id_sequence",
        sequenceName = "page_id_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "page_id_sequence"
    )
    val id: Long,
    /* = 0*/
    val userId: Long,
    val pageName: String,
    val updatedAt: Date = Date(),
    val createdAt: Date = Date(),
)

data class UpdatedPage(
    val id: Long,
    val userId: Long,
    val pageName: String
)