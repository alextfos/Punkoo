package com.alextfos.punkoo.styles.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val cornerRadius: Dp = 4.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }