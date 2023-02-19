package com.alextfos.search.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.punkoo.common.ui.components.ProgressBarFullScreen
import com.alextfos.punkoo.common.ui.navigation.Screen

fun NavGraphBuilder.addSearchScreen(navController: NavController) {
    composable(
        route = Screen.Search.route
    ) {
        SearchDrawer()
    }
}
