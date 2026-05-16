package com.example.rayfield.domain.ssh

import com.example.rayfield.data.ssh.CommandResult

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SshClient() {
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