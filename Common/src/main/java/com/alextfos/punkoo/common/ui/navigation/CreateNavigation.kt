package com.alextfos.punkoo.common.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun CreateNavigation(
    navController: NavHostController,
    initNavigation: (NavGraphBuilder)->Unit
) {
    NavHost(
        navController = navController,
        startDestination =  Screen.BeerList.route,
        builder = {
            initNavigation(this)
        }
    )
}
