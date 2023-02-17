package com.alextfos.punkoo.styles.ui.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class CustomTypography internal constructor(
    val title50: TextStyle,
    val body20: TextStyle,
    val button10: TextStyle
) {

    constructor(
        defaultFormFamily: FontFamily = FontFamily.Default,
        title40: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 30.sp
        ),
        title50: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            lineHeight = 22.4.sp
        ),
        body20: TextStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 19.2.sp
        ),
        button10: TextStyle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            lineHeight = 14.sp
        ),
    ) : this(
        title50 = title50.withDefaultFontFamily(defaultFormFamily),
        body20 = body20.withDefaultFontFamily(defaultFormFamily),
        button10 = button10.withDefaultFontFamily(defaultFormFamily)
    )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}
