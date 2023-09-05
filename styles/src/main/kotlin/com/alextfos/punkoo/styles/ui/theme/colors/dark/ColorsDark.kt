package com.alextfos.punkoo.styles.ui.theme.colors.dark

import androidx.compose.ui.graphics.Color
import com.alextfos.punkoo.styles.ui.theme.colors.Semantic
import com.alextfos.punkoo.styles.ui.theme.colors.Colors

class ColorsDark(
    semantic: Semantic
) : Colors() {

    override val background: Color = semantic.black
    override val text: Color = semantic.grayLight
    override val icon: Color = semantic.white
}