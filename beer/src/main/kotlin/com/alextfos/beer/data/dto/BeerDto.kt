package com.alextfos.beer.data.dto

import com.squareup.moshi.Json

data class BeerDto (

	@Json(name="id") val id : Int?,
	@Json(name="name") val name : String?,
	@Json(name="tagline") val tagline : String?,
	@Json(name="first_brewed") val first_brewed : String?,
	@Json(name="description") val description : String?,
	@Json(name="image_url") val image_url : String?,
	@Json(name="abv") val abv : Float?,
	@Json(name="ibu") val ibu : Float?,
	@Json(name="target_fg") val target_fg : Int?,
	@Json(name="target_og") val target_og : Float?,
	@Json(name="ebc") val ebc : Float?,
	@Json(name="srm") val srm : Float?,
	@Json(name="ph") val ph : Float?,
	@Json(name="attenuation_level") val attenuation_level : Float?,
	@Json(name="volume") val volumeDto : VolumeDto?,
	@Json(name="boil_volume") val boil_volume : BoilVolumeDto?,
	@Json(name="method") val methodDto : MethodDto?,
	@Json(name="ingredients") val ingredientsDto : IngredientsDto?,
	@Json(name="food_pairing") val food_pairing : List<String>?,
	@Json(name="brewers_tips") val brewers_tips : String?,
	@Json(name="contributed_by") val contributed_by : String?
)