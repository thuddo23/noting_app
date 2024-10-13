package com.example.demo.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import jakarta.persistence.*
import jakarta.validation.constraints.Size
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.ReadOnlyProperty
import java.time.LocalDateTime

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder("name", "email", "password", "createdAt", "updatedAt")
data class User(
    @Id
    @SequenceGenerator(
        name = "user_id_sequence",
        sequenceName = "user_id_sequence",
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_id_sequence",
    )
    @JsonIgnore
    val id: Long = 0,
    @Size(min = 2)
    @JsonProperty("name")
    val name: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("password")
    val password: String,
    @JsonProperty("createdAt", access = JsonProperty.Access.READ_ONLY)
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @JsonProperty("updatedAt", access = JsonProperty.Access.READ_ONLY)
    @ReadOnlyProperty
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now(),
) {
    /*   @OneToMany(mappedBy = "userId")
       lateinit var pages: List<Page>
       private set*/
}
