package com.example.rayfield

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform