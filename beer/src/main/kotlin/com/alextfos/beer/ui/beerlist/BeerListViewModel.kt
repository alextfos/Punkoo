package com.alextfos.beer.ui.beerlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import arrow.core.Either
import arrow.core.left
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.usecase.GetBeerListUseCase
import com.alextfos.beer.ui.common.BeerBoFlowState
import com.alextfos.punkoo.common.ext.toError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val getBeerListUseCase: GetBeerListUseCase
) : ViewModel() {

    var state by mutableStateOf(BeerBoFlowState())
        private set

    /*
    init {
        getBeerListUnUseCase()
    }
    */
     private fun getBeerListUnUseCase() {
         state = BeerBoFlowState(loading = true)
         state = try {
             val result = getBeerListUseCase.invoke().cachedIn(viewModelScope)
             BeerBoFlowState(beerList = Either.Right(result))
         } catch (t: Throwable) {
             BeerBoFlowState(beerList = t.toError().left())
         }
     }

    fun getBeerList() : Flow<PagingData<BeerBo>> {
        return  getBeerListUseCase.invoke().cachedIn(viewModelScope)
    }
}
