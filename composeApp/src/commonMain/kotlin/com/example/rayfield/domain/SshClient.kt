package com.example.rayfield.domain

import com.example.rayfield.data.xray.types.CommandResult

//
// Created by Kirill "Raaveinm" on 4/29/26.
//

interface SshClient {
    suspend fun connect (
        host: String,
        port: Int,
        username: String,
        password: String? = null,
        privateKey: ByteArray? = null,
    ) : Boolean

    suspend fun execute(command: String) : CommandResult
    suspend fun disconnect()
}