package com.example.rayfield.ui.state

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.example.rayfield.data.database.ServerDao
import com.example.rayfield.data.ssh.ServerUnit
import com.example.rayfield.data.xray.types.ServerState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainScreenModel(
    serverDao: ServerDao
) : ScreenModel {

    val serverStates: StateFlow<List<ServerState>> = serverDao.getAllServerStates()
        .stateIn(screenModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val serverUnits: StateFlow<List<ServerUnit>> = serverDao.getAllServerUnits()
        .stateIn(screenModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}