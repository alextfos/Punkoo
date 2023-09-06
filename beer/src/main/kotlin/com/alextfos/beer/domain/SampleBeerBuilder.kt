package com.alextfos.beer.domain

import com.alextfos.beer.domain.entity.BeerBo

class SampleBeerBuilder {
    private var id = 1
    private var name = "Sample beer"
    private var numElements: Int = 1

    fun withName(name: String): SampleBeerBuilder {
        this.name = name
        return this
    }

    fun withNumElements(numElements: Int): SampleBeerBuilder {
        this.numElements = numElements

        return this
    }

    fun buildSingle() = BeerBo(
        id = id,
        name = name,
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
