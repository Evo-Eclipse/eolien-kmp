package com.example.rayfield.data.database

import androidx.room3.Embedded
import androidx.room3.Relation
import com.example.rayfield.data.ssh.ServerUnit
import com.example.rayfield.data.xray.types.ServerState


data class ServerWithState(
    @Embedded val server: ServerUnit,
    @Relation(
        parentColumn = "serverId",
        entityColumn = "serverId"
    )
    val states: List<ServerState>
)
