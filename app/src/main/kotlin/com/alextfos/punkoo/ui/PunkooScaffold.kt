package com.alextfos.punkoo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alextfos.punkoo.R
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PunkooScaffold(
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
             TopAppBar(
                 title = { Text(stringResource(R.string.app_name)) }
             )
        },
        //backgroundColor = Theme.colors.background,
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
    PunkooTheme(ThemeType.LIGHT) {
        PunkooScaffold {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = "Test"
            )
        }
    }
}
