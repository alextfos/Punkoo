package com.alextfos.punkoo.common.ui.components.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alextfos.punkoo.common.R
import com.alextfos.punkoo.styles.ui.theme.Theme

@Composable
fun EmptyView(text: String? = null) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(400.dp)
            .fillMaxSize()
    ) {
        Text(
            text = text ?: stringResource(R.string.no_results_available),
            color = Theme.colors.text,
            style = Theme.typography.title,
            textAlign = TextAlign.Center,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ShowEmptyView() {
    EmptyView()
}