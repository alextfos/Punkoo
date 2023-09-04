package com.alextfos.punkoo.common.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val argument: List<NamedNavArgument>
) {
    object BeerList : Screen(
        route = "beerList",
        argument = emptyList()
    )

    object BeerDetail : Screen(
        route = "beerDetail",
        argument = listOf(
            navArgument("id")
            {
                type = NavType.StringType
            })
    )

    object Search : Screen(
        route = "search",
        argument = emptyList()
    )

    object Random : Screen(
        route = "random",
        argument = emptyList()
    )
}
