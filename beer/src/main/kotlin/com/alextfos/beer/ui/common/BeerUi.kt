package com.alextfos.beer.ui.common

data class BeerUi(
    val id: Int,
    val name: String,
    val tagLine: String,
    val description: String,
    val imageUrl: String,
    val ibu: String,
    val foodPairing: List<String>,
    val brewersTips: String
)
