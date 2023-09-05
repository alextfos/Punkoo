package com.alextfos.beer.ui.beerlist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.beer.ui.random.RandomDrawer
import com.alextfos.punkoo.common.ui.navigation.Screen

fun NavGraphBuilder.addBeerListScreen(navController: NavController) {
    composable(
        route = Screen.BeerList.route
    ) {
        BeerListDrawer()
    }
}
