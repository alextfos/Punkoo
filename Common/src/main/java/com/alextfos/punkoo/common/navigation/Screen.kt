package com.alextfos.punkoo.common.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    protected val baseRoute: String = route,
    val arguments: List<NamedNavArgument>
) {
    data object BeerList : Screen(
        route = "BeerList",
        arguments = emptyList()
    )
    data object BeerDetail : Screen(
        route = "BeerDetail/{beerId}",
        baseRoute = "BeerDetail",
        arguments = listOf(
            navArgument("beerId")
            {
                type = NavType.IntType
            })
    ) {
        fun createRoute(beerId: Int) = "$baseRoute/$beerId"
    }
    data object SearchBeer
        : Screen(
        route = "SearchBeer",
        arguments = emptyList()
    )

    companion object {
        fun findRoute(route: String?): Screen {
            return if (route?.contains(BeerDetail.route) == true) {
                BeerDetail
            } else {
                BeerList
            }
        }
    }
}
