package com.example.rayfield.domain.xray

import com.example.rayfield.data.xray.types.XrayKeyPair


expect class CypherService() {
    fun generateUuid(): String
    fun generateShortId(): String
    fun generateKeyPair(): XrayKeyPair
}
