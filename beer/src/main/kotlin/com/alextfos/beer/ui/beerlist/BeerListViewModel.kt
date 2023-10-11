package com.alextfos.beer.ui.beerlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.alextfos.beer.di.BeerDetailContainer
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.mapper.toBeerUi
import com.alextfos.beer.domain.usecase.GetBeerListUseCase
import com.alextfos.beer.ui.common.BeerUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val getBeerListUseCase: GetBeerListUseCase,
    @Named("beerDetail") val beerDetailContainer: BeerDetailContainer
) : ViewModel() {

    fun selectBeer(beerUi: BeerUi) {
        beerDetailContainer.beerUi = beerUi
    }

    fun getBeerList() : Flow<PagingData<BeerUi>> {
        return  getBeerListUseCase.invoke().map {
            it.map {
                it.toBeerUi()
            }
        }.cachedIn(viewModelScope)
    }
}
