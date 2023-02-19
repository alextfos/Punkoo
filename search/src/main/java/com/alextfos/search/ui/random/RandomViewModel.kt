package com.alextfos.search.ui.random

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alextfos.search.domain.usecase.GetRandomUseCase
import com.alextfos.search.ui.BeerBoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val getRandomUseCase: GetRandomUseCase
): ViewModel() {

    var state by mutableStateOf(BeerBoUiState())
        private set

    init {
        getRandomBeer()
    }

    private fun getRandomBeer() {
        viewModelScope.launch {
            state = BeerBoUiState(loading = true)
            state = BeerBoUiState(searchResult = getRandomUseCase.invoke())
        }
    }
}