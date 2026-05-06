package com.example.rayfield.domain

import com.example.rayfield.data.XrayKeyPair

//
// Created by Kirill "Raaveinm" on 4/29/26.
//

interface CypherService {
    fun generateUuid(): String
    fun generateShortId(): String
    fun generateKeyPair(): XrayKeyPair
}