package com.example.rayfield.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
actual fun RayFieldTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) { 
    val colorScheme = when {
        dynamicColor && darkTheme -> darkScheme
        dynamicColor -> lightScheme
        darkTheme -> darkScheme
        else -> lightScheme
    }
    
    MaterialTheme(
        colorScheme = colorScheme, 
        typography = AppTypography, 
        shapes = RayShapes,
        content = content
    )
}
