package com.example.rayfield.data

data class CommandResult(
    val exitCode: Int,
    val stdout: String,
    val error: String? = null
)