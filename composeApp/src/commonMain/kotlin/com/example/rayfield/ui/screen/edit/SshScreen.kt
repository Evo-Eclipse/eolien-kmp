package com.example.rayfield.ui.screen.edit

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.rayfield.data.ssh.ServerUnit

//
// Created by Kirill "Raaveinm" on 5/4/26.
//

data class SshScreen(
    val serverUnit: ServerUnit?
) : Screen {
    @Composable
    override fun Content() {

    }
}
