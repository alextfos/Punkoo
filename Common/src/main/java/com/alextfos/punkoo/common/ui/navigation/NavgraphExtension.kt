package com.alextfos.punkoo.common.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.punkoo.common.ui.components.ProgressBarFullScreen
import com.alextfos.punkoo.common.ui.navigation.Screen


fun NavGraphBuilder.addMainScreen(navController: NavController) {
    composable(
        route = Screen.Main.route
    ) {
        ProgressBarFullScreen()
    }
}
