package com.alextfos.punkoo.styles.ui.theme

import androidx.compose.runtime.Composable
import com.alextfos.punkoo.styles.ui.theme.colors.Colors
import com.alextfos.punkoo.styles.ui.theme.objectstyle.CompoundObjectStyle
import com.alextfos.punkoo.styles.ui.theme.typography.CustomTypography

object Theme {

    val colors: Colors
        @Composable
        get() = LocalPunkooColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalPunkooTypography.current
    val objectStyle: CompoundObjectStyle
        @Composable
        get() = LocalPunkooObjectStyle.current
}