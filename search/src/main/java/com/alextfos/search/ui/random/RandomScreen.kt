package com.alextfos.search.ui.random

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.punkoo.common.ui.navigation.Screen

fun NavGraphBuilder.addRandomScreen(navController: NavController) {
    composable(
        route = Screen.Random.route
    ) {
        RandomDrawer()
    }
}
