package com.alextfos.punkoo.common.ui.components.error

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alextfos.punkoo.common.R
import com.alextfos.punkoo.common.domain.entity.Error
import com.alextfos.punkoo.styles.ui.theme.spacing
import timber.log.Timber

@Composable
fun ErrorView(
    error: Error = Error.Unknown("Unknown"),
    onRetry: (() -> Unit)? = null
) {
    when (error) {
        is Error.EmptyView,
        is Error.Connectivity,
        is Error.Unknown -> {
            GenericErrorView(
                title = stringResource(
                    when (error) {
                        is Error.EmptyView -> {
                            R.string.error_empty_title
                        }
                        is Error.Connectivity -> {
                            R.string.error_empty_title
                        }
                        else -> {
                            R.string.error_unknown_title
                        }
                    }
                ),
                text = stringResource(
                    when (error) {
                        is Error.EmptyView -> {
                            R.string.error_empty_text
                        }
                        is Error.Connectivity -> {
                            R.string.error_empty_text
                        }
                        else -> {
                            R.string.error_unknown_text
                        }
                    }
                ),
                painter = painterResource(
                    when (error) {
                        is Error.EmptyView -> {
                            R.drawable.ic_offline
                        }
                        is Error.Connectivity -> {
                            R.drawable.ic_offline
                        }
                        else -> {
                            R.drawable.ic_unknown_error
                        }
                    }
                ),
                onRetry = onRetry
            )
        }
    }
}


@Composable
private fun GenericErrorView(
    title: String,
    text: String,
    painter: Painter,
    onRetry: (() -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp - 120.dp)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.surfaceTint),
                painter = painter,
                contentDescription = stringResource(R.string.error_image_description)
            )
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(top = 11.dp, bottom = 4.dp)
            )
            Text(
                text,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
        }
        onRetry?.let {
            Button(
                shape = RoundedCornerShape(MaterialTheme.spacing.cornerRadius),
                colors = ButtonDefaults.buttonColors(
                    //backgroundColor = Theme.colors.background
                ),
                onClick = it,
                modifier = Modifier.padding(top = 24.dp),
                // TODO elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(
                    stringResource(R.string.error_retry),
                    // TODO style = Theme.typography.textButton,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun TestGenericErrorView() {
    GenericErrorView(
        title = "Test title",
        text = "Test text error",
        painter = painterResource(id = R.drawable.ic_offline)
    )
    {
        Timber.d("test")
    }
}