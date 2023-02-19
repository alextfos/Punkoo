package com.alextfos.punkoo.common.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val argument: List<NamedNavArgument>
) {
    object Search : Screen(
        route = "search",
        argument = emptyList()
    )
    object Random : Screen(
        route = "random",
        argument = emptyList()
    )
}
