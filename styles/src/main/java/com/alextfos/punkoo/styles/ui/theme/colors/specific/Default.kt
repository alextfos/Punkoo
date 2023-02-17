package com.alextfos.punkoo.styles.ui.theme.colors.specific

import androidx.compose.ui.graphics.Color
import com.alextfos.punkoo.styles.ui.theme.colors.global.palettes.Palette

abstract class Default(
    palette: Palette
) {

    abstract val bg: Color
    abstract val textStrong: Color
    abstract val textMedium: Color
    abstract val textWeak: Color
    abstract val textAccent: Color
    abstract val iconStrong: Color
    abstract val iconMedium: Color
}