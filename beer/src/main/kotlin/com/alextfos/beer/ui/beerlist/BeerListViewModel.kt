package com.alextfos.beer.ui.beerlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.usecase.GetBeerListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val getBeerListUseCase: GetBeerListUseCase
) : ViewModel() {


    fun getBeerList() : Flow<PagingData<BeerBo>> {
        return  getBeerListUseCase.invoke().cachedIn(viewModelScope)
    }
}
