package com.example.rayfield.ui.animations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition


@Composable
fun StatefulSlideTransition(
    navigator: Navigator,
    backNavState: MutableState<Navigator?>
)  {
    DisposableEffect(navigator) {
        backNavState.value = navigator
        onDispose {
            if (backNavState.value == navigator) {
                backNavState.value = null
            }
        }
    }
    SlideTransition(navigator)
}