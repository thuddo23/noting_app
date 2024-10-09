package com.example.demo.domain.model

import jakarta.persistence.*
import jakarta.validation.constraints.Size
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
    val id: Long = 0,
    @Size(min = 2)
    val name: String,
    val email: String,
    val password: String,
    val createdAt: Date,
    val updatedAt: Date?
) {

 /*   @OneToMany(mappedBy = "userId")
    lateinit var pages: List<Page>
    private set*/
}