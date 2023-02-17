package com.alextfos.punkoo.styles.ui.theme.colors.specific.light.definitions

import androidx.compose.ui.graphics.Color
import com.alextfos.punkoo.styles.ui.theme.colors.global.palettes.Palette
import com.alextfos.punkoo.styles.ui.theme.colors.specific.Default

class DefaultLight(
    palette: Palette
) : Default(palette) {

    override val bg: Color = palette.neutrals.neutral20
    override val textStrong: Color = palette.neutrals.neutral100
    override val textMedium: Color = palette.neutrals.neutral80
    override val textWeak: Color = palette.neutrals.neutral50
    override val textAccent: Color = palette.neutrals.neutral80
    override val iconStrong: Color = palette.neutrals.neutral100
    override val iconMedium: Color = palette.neutrals.neutral80
}