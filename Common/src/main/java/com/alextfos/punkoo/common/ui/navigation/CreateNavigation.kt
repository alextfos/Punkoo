package com.alextfos.punkoo.common.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alextfos.punkoo.core.ui.navigation.addMainScreen

@Composable
fun CreateNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination =  Screen.Main.route,
        builder = {
            addMainScreen(navController)
        }
    )
}
