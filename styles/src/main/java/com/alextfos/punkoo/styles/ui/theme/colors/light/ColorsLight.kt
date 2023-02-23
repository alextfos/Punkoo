package com.alextfos.punkoo.styles.ui.theme.colors.light

import androidx.compose.ui.graphics.Color
import com.alextfos.punkoo.styles.ui.theme.colors.Semantic
import com.alextfos.punkoo.styles.ui.theme.colors.Colors

class ColorsLight(
    semantic: Semantic
) : Colors(semantic) {

    override val background: Color = semantic.white
    override val text: Color = semantic.black
    override val icon: Color = semantic.grayBlack
}
