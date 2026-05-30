package com.example.rayfield.ui.adapters

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.rayfield.domain.helpers.LocalWindowSize
import com.example.rayfield.domain.helpers.WindowSize
import com.example.rayfield.ui.theme.LocalDimensions


object AdaptivePadding{
    val adaptiveCompact: PaddingValues
        @Composable
        get() {
            val dimen = LocalDimensions.current
            val windowSize = LocalWindowSize.current
            return PaddingValues(
                top = dimen.sMediumMargin,
                bottom = dimen.mediumMargin,
                start = if (windowSize != WindowSize.COMPACT) dimen.extraSmallMargin
                else dimen.mediumPadding,
                end = if (windowSize != WindowSize.COMPACT) dimen.extraSmallMargin
                else dimen.mediumPadding
            )
        }

    val adaptiveAll: PaddingValues
        @Composable
        get() {
            val dimen = LocalDimensions.current
            val windowSize = LocalWindowSize.current
            return when (windowSize) {
                WindowSize.EXPANDED -> PaddingValues(
                    all = dimen.sMediumMargin
                )
                WindowSize.COMPACT -> PaddingValues(
                    vertical = dimen.smallSize,
                    horizontal = dimen.sMediumPadding,
                )
                WindowSize.MEDIUM -> PaddingValues(
                    vertical = dimen.smallMargin,
                    horizontal = dimen.extraSmallMargin,
                )
            }
        }

    val adaptiveExtended: PaddingValues
    @Composable
    get() {
        val dimen = LocalDimensions.current
        val windowSize = LocalWindowSize.current
        return when (windowSize) {
            WindowSize.EXPANDED -> PaddingValues(
                vertical = dimen.mediumMargin,
                horizontal = dimen.sMediumMargin
            )
            WindowSize.COMPACT -> PaddingValues(
                vertical = dimen.mediumMargin,
                horizontal = dimen.sMediumPadding,
            )
            WindowSize.MEDIUM -> PaddingValues(
                vertical = dimen.mediumMargin,
                horizontal = dimen.extraSmallMargin,
            )
        }
    }
}