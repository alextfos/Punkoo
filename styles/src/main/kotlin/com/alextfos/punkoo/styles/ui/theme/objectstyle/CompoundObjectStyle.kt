package com.alextfos.punkoo.styles.ui.theme.objectstyle

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alextfos.punkoo.styles.ui.theme.objectstyle.light.BorderRadiusLight

data class CompoundObjectStyle(
    val borderRadius: BorderRadius = BorderRadiusLight()
) {
    val elevation: Dp = 4.dp
}