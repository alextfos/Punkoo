package com.alextfos.punkoo.styles.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.alextfos.punkoo.styles.ui.theme.colors.Colors
import com.alextfos.punkoo.styles.ui.theme.colors.Semantic
import com.alextfos.punkoo.styles.ui.theme.colors.dark.ColorsDark
import com.alextfos.punkoo.styles.ui.theme.colors.light.ColorsLight
import com.alextfos.punkoo.styles.ui.theme.objectstyle.CompoundObjectStyle
import com.alextfos.punkoo.styles.ui.theme.objectstyle.dark.BorderRadiusDark
import com.alextfos.punkoo.styles.ui.theme.objectstyle.light.BorderRadiusLight
import com.alextfos.punkoo.styles.ui.theme.typography.CustomTypography

@Composable
fun PunkooTheme(type: ThemeType, content: @Composable () -> Unit) {
    val semantic = Semantic()
    val specific = when (type) {
        ThemeType.LIGHT -> ColorsLight(semantic)
        ThemeType.DARK -> ColorsDark(semantic)
    }
    val borderRadius = when (type) {
        ThemeType.LIGHT -> BorderRadiusLight()
        ThemeType.DARK -> BorderRadiusDark()
    }
    val compoundObjectStyle = CompoundObjectStyle(borderRadius = borderRadius)

    CompositionLocalProvider(
        LocalPunkooColors provides specific,
        LocalPunkooTheme provides type,
        LocalPunkooObjectStyle provides compoundObjectStyle
    ) {
        content()
    }
}

internal val LocalPunkooColors: ProvidableCompositionLocal<Colors> = staticCompositionLocalOf {
    ColorsDark(Semantic())
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