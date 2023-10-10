package com.alextfos.punkoo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.punkoo.R
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.Theme
import com.alextfos.punkoo.styles.ui.theme.ThemeType

@Composable
fun PunkooScaffold(
    scaffoldState: ScaffoldState,
    content: @Composable () -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
             TopAppBar(
                 title = { Text(stringResource(R.string.app_name)) }
             )
        },
        backgroundColor = Theme.colors.background,
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Box(
            modifier = Modifier
                .padding(it)
        ) {
            content()
        }
    }
}

@Composable
@Preview
fun PunkooScaffoldPreview() {
    val scaffoldState = rememberScaffoldState()

    PunkooTheme(ThemeType.LIGHT) {
        PunkooScaffold(scaffoldState = scaffoldState) {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = "Test"
            )
        }
    }
}
