package com.alextfos.beer.ui.detail

import androidx.lifecycle.ViewModel
import com.alextfos.beer.di.BeerDetailContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    @Named("beerDetail") private val beerDetailContainer: BeerDetailContainer
) : ViewModel() {
    val beer = beerDetailContainer.beerUi
}
