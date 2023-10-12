package com.alextfos.beer.ui

import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.ui.common.BeerUi

class SampleBeerUiBuilder {
    private var id = 1
    private var name = "Sample beer"
    private var tagLine = "Sample tag line"
    private var description = " This beer is amazing bla bla bla bla amzing glu glu glu"
    private var imageUrl = "https://images.punkapi.com/v2/keg.png"
    private var ibu = "1.0"
    private var foodPairing = mutableListOf("Oysters", "Cheese")
    private var brewersTips = "Tips for happy drinking"

    private var numElements: Int = 1

    fun withName(name: String): SampleBeerUiBuilder {
        this.name = name

        return this
    }

    fun withTagLine(tagLine: String): SampleBeerUiBuilder {
        this.tagLine = tagLine

        return this
    }

    fun withDescription(description: String): SampleBeerUiBuilder {
        this.description = description

        return this
    }

    fun withImageUrl(imageUrl: String): SampleBeerUiBuilder {
        this.imageUrl = imageUrl

        return this
    }

    fun withIbu(ibu: String): SampleBeerUiBuilder {
        this.ibu = ibu

        return this
    }

    fun withFoodPairing(foodPairing: MutableList<String>): SampleBeerUiBuilder {
        this.foodPairing = foodPairing

        return this
    }

    fun addFoodPairing(foodPairing: String): SampleBeerUiBuilder {
        this.foodPairing.add(foodPairing)

        return this
    }

    fun withNumElements(numElements: Int): SampleBeerUiBuilder {
        this.numElements = numElements

        return this
    }

    fun buildSingle() = BeerUi(
        id = id,
        name = name,
        tagLine = tagLine,
        description = description,
        imageUrl = imageUrl,
        ibu = ibu,
        foodPairing = foodPairing,
        brewersTips = brewersTips
    )

    fun buildList(): List<BeerUi> {
        val list = mutableListOf<BeerUi>()

        for (i in 0..numElements) {
            list.add(buildSingle())
            id++
        }

        return list.toList()
    }
}
