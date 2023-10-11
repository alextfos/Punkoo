package com.alextfos.beer.ui.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alextfos.beer.domain.usecase.GetRandomBeerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val getRandomBeerUseCase: GetRandomBeerUseCase
): ViewModel() {

    init {
        getRandomBeer()
    }

    private fun getRandomBeer() {
        viewModelScope.launch {
            // TODO state = BeerBoState(loading = true)
            // state = BeerBoState(searchResult = getRandomBeerUseCase.invoke())
        }
    }
}
