package com.example.rayfield

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.rayfield.domain.SshClientJvm

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "RayField",
    ) {

        val client = SshClientJvm()

        App(client)
    }
}