package com.example.demo.domain.repository

import com.example.demo.domain.model.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PageRepository: JpaRepository<Page, Long> {

    @Query("SELECT p FROM Page p WHERE p.userId = :userId")
    fun findByUserId(userId: Long): List<Page>
}