package com.alextfos.beer.data.dto

import com.squareup.moshi.Json

data class BeerDto (

	@Json(name="id") val id : Int?,
	@Json(name="name") val name : String?,
	@Json(name="tagline") val tagline : String?,
	@Json(name="first_brewed") val firstBrewed : String?,
	@Json(name="description") val description : String?,
	@Json(name="image_url") val imageUrl : String?,
	@Json(name="abv") val abv : Float?,
	@Json(name="ibu") val ibu : Float?,
	@Json(name="target_fg") val targetFg : Int?,
	@Json(name="target_og") val targetOg : Float?,
	@Json(name="ebc") val ebc : Float?,
	@Json(name="srm") val srm : Float?,
	@Json(name="ph") val ph : Float?,
	@Json(name="attenuation_level") val attenuationLevel : Float?,
	@Json(name="volume") val volumeDto : VolumeDto?,
	@Json(name="boil_volume") val boilVolume : BoilVolumeDto?,
	@Json(name="method") val methodDto : MethodDto?,
	@Json(name="ingredients") val ingredientsDto : IngredientsDto?,
	@Json(name="food_pairing") val foodPairing : List<String>?,
	@Json(name="brewers_tips") val brewersTips : String?,
	@Json(name="contributed_by") val contributedBy : String?
)