package com.example.rayfield.data.xray.types


import kotlinx.serialization.Serializable

@Serializable
data class XrayKeyPair(
    val publicKey: String,
    val privateKey: String
)
