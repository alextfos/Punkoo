package com.alextfos.punkoo.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alextfos.punkoo.common.ui.navigation.CreateNavigation
import com.alextfos.punkoo.styles.ui.theme.PunkooTheme
import com.alextfos.punkoo.styles.ui.theme.ThemeType
import com.alextfos.beer.ui.search.addSearchScreen
import com.alextfos.beer.ui.random.addRandomScreen


@Composable
fun PunkooApp(
    navController: NavHostController = rememberNavController(),
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    PunkooTheme(ThemeType.LIGHT) {
        InitAppScaffold(scaffoldState) {
            CreateNavigation(
                navController,
            ) {
                it.addSearchScreen(navController)
                it.addRandomScreen(navController)
            }
        }
    }
}
