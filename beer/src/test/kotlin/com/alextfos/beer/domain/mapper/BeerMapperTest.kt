package com.alextfos.beer.domain.mapper

import com.alextfos.beer.data.dto.BeerDto
import com.alextfos.beer.data.dto.BoilVolumeDto
import com.alextfos.beer.data.dto.IngredientsDto
import com.alextfos.beer.data.dto.MethodDto
import com.alextfos.beer.data.dto.VolumeDto
import com.alextfos.beer.domain.SampleBeerBoBuilder
import com.alextfos.beer.ui.SampleBeerUiBuilder
import com.squareup.moshi.Json
import org.hamcrest.CoreMatchers.both
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class BeerMapperTest {

    @Test
    fun `WHEN map dto null EXPECT empty fields`() {
        val beerDto = BeerDto(
            id = null,
            name = null,
            tagline = null,
            firstBrewed = null,
            description = null,
            imageUrl = null,
            abv = null,
            ibu = null,
            targetFg = null,
            targetOg = null,
            ebc = null,
            srm = null,
            ph = null,
            attenuationLevel = null,
            volumeDto = null,
            boilVolume = null,
            methodDto = null,
            ingredientsDto = null,
            foodPairing = null,
            brewersTips = null,
            contributedBy = null
        )
        val res = beerDto.toBeerBo()

        assertThat(res.id, `is`(0))
        assertThat(res.name, both(notNullValue()).and(`is`("")))
    }

    @Test
    fun `WHEN maps a beer EXPECT right ibu mapping`() {
        val beer = SampleBeerBoBuilder().withIbu(1f).buildSingle()
        val res = beer.toBeerUi()

        assertThat(res.ibu, `is`("1.0"))
        assertThat(res, notNullValue())
    }
}