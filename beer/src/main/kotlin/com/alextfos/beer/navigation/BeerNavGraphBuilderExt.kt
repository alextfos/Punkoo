package com.alextfos.beer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.beer.ui.beerlist.BeerListDrawer
import com.alextfos.beer.ui.detail.BeerDetailScreen
import com.alextfos.punkoo.common.navigation.Screen

fun NavGraphBuilder.addBeerListScreen(onBeerClick: (Int) -> Unit) {
    composable(
        route = Screen.BeerList.route
    ) {
        BeerListDrawer(onBeerClick = onBeerClick)
    }
}


fun NavGraphBuilder.addBeerDetailScreen() {
    composable(
        route = Screen.BeerDetail.route,
        arguments = Screen.BeerDetail.arguments
    ) {
        BeerDetailScreen()
    }
}