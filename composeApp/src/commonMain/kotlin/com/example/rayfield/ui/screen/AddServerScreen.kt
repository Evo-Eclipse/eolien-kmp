package com.example.rayfield.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.rayfield.ui.screen.edit.SshScreen

//
// Created by Kirill "Raaveinm" on 5/4/26.
//

class AddServerScreen : Screen {
    @Composable
    override fun Content() {
        SshScreen()
    }
}