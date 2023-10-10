package com.alextfos.punkoo.ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alextfos.beer.ui.beerlist.addBeerListScreen
import com.alextfos.punkoo.common.ui.navigation.CreateNavigation
import com.alextfos.punkoo.styles.ui.theme.ThemeType
import com.alextfos.beer.ui.search.addSearchScreen
import com.alextfos.beer.ui.random.addRandomScreen
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme


@Composable
fun PunkooApp(
    navController: NavHostController = rememberNavController(),
) {
    val selectedTheme = if (isSystemInDarkTheme()) {
        ThemeType.DARK
    } else {
        ThemeType.LIGHT
    }

    PunkooTheme(selectedTheme) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            PunkooScaffold {
                CreateNavigation(
                    navController,
                ) {
                    it.addBeerListScreen(navController)
                    it.addSearchScreen(navController)
                    it.addRandomScreen(navController)
                }
            }
        }
    }
}
