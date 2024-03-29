package com.alextfos.beer.domain

import com.alextfos.beer.domain.entity.BeerBo

class SampleBeerBoBuilder {
    private var id = 1
    private var name = "Sample beer"
    private var tagLine = "Sample tag line"
    private var description = " This beer is amazing bla bla bla bla amzing glu glu glu"
    private var imageUrl = "https://images.punkapi.com/v2/keg.png"
    private var ibu = 1.0f
    private var foodPairing = mutableListOf("Oysters", "Cheese")
    private var brewersTips = "Tips for happy drinking"

    private var numElements: Int = 1

    fun withName(name: String): SampleBeerBoBuilder {
        this.name = name

        return this
    }

    fun withTagLine(tagLine: String): SampleBeerBoBuilder {
        this.tagLine = tagLine

        return this
    }

    fun withDescription(description: String): SampleBeerBoBuilder {
        this.description = description

        return this
    }

    fun withImageUrl(imageUrl: String): SampleBeerBoBuilder {
        this.imageUrl = imageUrl

        return this
    }

    fun withIbu(ibu: Float): SampleBeerBoBuilder {
        this.ibu = ibu

        return this
    }

    fun withFoodPairing(foodPairing: MutableList<String>): SampleBeerBoBuilder {
        this.foodPairing = foodPairing

        return this
    }

    fun addFoodPairing(foodPairing: String): SampleBeerBoBuilder {
        this.foodPairing.add(foodPairing)

        return this
    }

    fun withNumElements(numElements: Int): SampleBeerBoBuilder {
        this.numElements = numElements

        return this
    }

    fun buildSingle() = BeerBo(
        id = id,
        name = name,
        tagLine = tagLine,
        description = description,
        imageUrl = imageUrl,
        ibu = ibu,
        foodPairing = foodPairing,
        brewersTips = brewersTips
    )

    fun buildList(): List<BeerBo> {
        val list = mutableListOf<BeerBo>()

        for (i in 0..numElements) {
            list.add(buildSingle())
            id++
        }

        return list.toList()
    }
}
