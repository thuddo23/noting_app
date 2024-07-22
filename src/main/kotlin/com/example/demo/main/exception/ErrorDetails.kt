package com.example.demo.main.exception

import java.util.Date

data class ErrorDetails(
    val timestamp: Date,
    val message: String,
    val details: String,
)
