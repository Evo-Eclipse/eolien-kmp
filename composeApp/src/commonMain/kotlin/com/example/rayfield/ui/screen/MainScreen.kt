package com.example.rayfield.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rayfield.domain.helpers.ClipboardHelper
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.rayfield.ui.adapters.AdaptivePadding.adaptiveCompact
import com.example.rayfield.ui.fragments.ConnectionInfoCard
import com.example.rayfield.ui.navigation.AddServerTab
import com.example.rayfield.ui.navigation.EditTab
import com.example.rayfield.ui.state.MainScreenModel
import com.example.rayfield.ui.theme.LocalDimensions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<MainScreenModel>()
        val serverStates by screenModel.serverStates.collectAsState()

        val scope = rememberCoroutineScope()
        val navigator = LocalTabNavigator.current
        val state = rememberLazyGridState()
        val dimen = LocalDimensions.current
        val mediumPadding = dimen.mediumPadding // 16.dp

        LaunchedEffect(serverStates.isEmpty()) {
            if (serverStates.isEmpty()) {
                delay(300)
                navigator.current = AddServerTab
            }
        }

        Column(modifier = Modifier.fillMaxSize()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 360.dp),
                state = state,
                contentPadding = adaptiveCompact,
                horizontalArrangement = Arrangement.spacedBy(mediumPadding),
                verticalArrangement = Arrangement.spacedBy(mediumPadding),
                modifier = Modifier.fillMaxSize()
            ) {
                items(serverStates) { serverState -> // TODO (serverState to read from db)
                    ConnectionInfoCard(
                        serverState = serverState,
                        modifier = Modifier.fillMaxWidth(),
                        onCopyClick = { text ->
                            scope.launch { ClipboardHelper.setText(text) }
                        },
                        onQrClick = { /* Handle QR */ },
                        onShareClick = { /* Handle Share */ },
                        onEditClick = { navigator.current = EditTab(serverState.serverId) }
                    )
                }
            }
        }
    }
}
