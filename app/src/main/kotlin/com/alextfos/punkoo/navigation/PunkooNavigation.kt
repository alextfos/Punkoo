package com.alextfos.punkoo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.alextfos.punkoo.common.navigation.Screen

@Composable
fun PunkooNavigation(
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
