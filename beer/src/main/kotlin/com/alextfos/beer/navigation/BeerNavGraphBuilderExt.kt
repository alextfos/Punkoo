package com.alextfos.beer.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.beerlist.BeerListDrawer
import com.alextfos.beer.ui.common.BeerUi
import com.alextfos.beer.ui.detail.BeerDetailDrawer
import com.alextfos.beer.ui.detail.BeerDetailScreen
import com.alextfos.punkoo.common.ui.components.error.ErrorView

fun NavGraphBuilder.addBeerListScreen(onBeerClick: (BeerUi) -> Unit) {
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
