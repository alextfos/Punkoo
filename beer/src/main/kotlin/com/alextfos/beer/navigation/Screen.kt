package com.alextfos.beer.navigation

import androidx.navigation.NamedNavArgument
import com.alextfos.beer.ui.common.BeerUi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

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
        route = "BeerDetail",
        arguments = listOf()
    ) {
        fun createRoute(beerUi: BeerUi): String {
            val moshi = Moshi.Builder().build()
            val jsonAdapter: JsonAdapter<BeerUi> = moshi.adapter(BeerUi::class.java)
            return "$baseRoute/${jsonAdapter.toJson(beerUi)}"
        }
    }

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
