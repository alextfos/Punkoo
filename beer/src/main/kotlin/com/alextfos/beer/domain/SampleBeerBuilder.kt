package com.alextfos.beer.domain

import com.alextfos.beer.domain.entity.BeerBo

class SampleBeerBuilder {
    private var id = 1
    private var name = "Sample beer"
    private var tagLine = "Sample tag line"
    private var imageUrl = "https://images.punkapi.com/v2/keg.png"
    private var numElements: Int = 1

    fun withName(name: String): SampleBeerBuilder {
        this.name = name

        return this
    }

    fun withTagLine(tagLine: String): SampleBeerBuilder {
        this.tagLine = tagLine

        return this
    }

    fun withNumElements(numElements: Int): SampleBeerBuilder {
        this.numElements = numElements

        return this
    }

    fun withImageUrl(imageUrl: String): SampleBeerBuilder {
        this.imageUrl = imageUrl

        return this
    }

    fun buildSingle() = BeerBo(
        id = id,
        name = name,
        tagLine = tagLine,
        imageUrl = imageUrl
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
