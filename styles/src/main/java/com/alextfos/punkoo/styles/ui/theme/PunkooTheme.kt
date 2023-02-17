package com.alextfos.punkoo.styles.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.alextfos.punkoo.styles.ui.theme.colors.global.palettes.DarkPalette
import com.alextfos.punkoo.styles.ui.theme.colors.global.palettes.LightPalette
import com.alextfos.punkoo.styles.ui.theme.colors.global.palettes.Palette
import com.alextfos.punkoo.styles.ui.theme.colors.specific.Specific
import com.alextfos.punkoo.styles.ui.theme.colors.specific.dark.SpecificDark
import com.alextfos.punkoo.styles.ui.theme.colors.specific.light.SpecificLight
import com.alextfos.punkoo.styles.ui.theme.objectstyle.CompoundObjectStyle
import com.alextfos.punkoo.styles.ui.theme.typography.CustomTypography

@Composable
fun PunkooTheme(type: ThemeType, content: @Composable () -> Unit) {
    val palette: Palette = when (type) {
        ThemeType.LIGHT -> LightPalette()
        ThemeType.DARK -> DarkPalette()
    }
    val specific = when (type) {
        ThemeType.LIGHT -> SpecificLight(palette)
        ThemeType.DARK -> SpecificDark(palette)
    }

    CompositionLocalProvider(
        LocalPunkooColors provides specific,
        LocalPunkooTheme provides type
    ) {
        content()
    }
}

internal val LocalPunkooColors: ProvidableCompositionLocal<Specific> = staticCompositionLocalOf {
    SpecificDark(DarkPalette())
}

internal val LocalPunkooTypography = staticCompositionLocalOf {
    CustomTypography()
}

internal val LocalPunkooObjectStyle = staticCompositionLocalOf {
    CompoundObjectStyle()
}

internal val LocalPunkooTheme = staticCompositionLocalOf {
    ThemeType.LIGHT
}