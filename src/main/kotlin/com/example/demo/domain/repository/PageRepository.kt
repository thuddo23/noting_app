package com.example.demo.domain.repository

import com.example.demo.domain.model.Page
import org.springframework.data.jpa.repository.JpaRepository

interface PageRepository: JpaRepository<Page, Long>