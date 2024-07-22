package com.example.demo.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Page(
    @Id
    @GeneratedValue
    val pageId: String,
    val pageName: String,
    val workspaceId: String,
    val parentPageId: String?,
    val createdAt: String
)