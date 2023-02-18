package com.alextfos.punkoo.common.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val argument: List<NamedNavArgument>
) {
    object Main : Screen(
        route = "main",
        argument = emptyList()
    )
}
