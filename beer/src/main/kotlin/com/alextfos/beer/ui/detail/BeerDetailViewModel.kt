package com.alextfos.beer.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alextfos.punkoo.common.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val beerId = savedStateHandle.get<Int>(Screen.BeerDetail.arguments[0].name) ?: ""
}
