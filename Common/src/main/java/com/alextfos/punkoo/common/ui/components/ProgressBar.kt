package com.alextfos.punkoo.common.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alextfos.punkoo.styles.ui.theme.Theme
import com.alextfos.punkoo.common.R


@Composable
fun ProgressBarFullScreen() {
    ProgressBarModule(
        backgroundColor = Theme.colors.default.bg,
        fillColor = Theme.colors.default.iconStrong
    )
}

@Composable
fun ProgressBarModule(
    backgroundColor: Color = Color.Transparent,
    fillColor: Color = Theme.colors.default.iconStrong
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        var currentRotation by remember { mutableStateOf(0f) }

        val rotation = remember { Animatable(currentRotation) }

        val isPlaying = true
        LaunchedEffect(isPlaying) {
            rotation.animateTo(
                targetValue = currentRotation + 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            ) {
                currentRotation = value
            }
        }

        Image(
            modifier = Modifier.rotate(
                rotation.value
            ),
            colorFilter = ColorFilter.tint(fillColor),
            painter = painterResource(id = R.drawable.ic_loading),
            contentDescription = stringResource(R.string.loading)
        )
    }
}

