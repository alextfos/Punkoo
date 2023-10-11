package com.alextfos.beer.domain.entity

data class BeerBo(
    val id: Int,
    val name: String,
    val tagLine: String,
    val description: String,
    val imageUrl: String,
    val ibu: Float?,
    val foodPairing: List<String>,
    val brewersTips: String
)
