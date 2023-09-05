package com.alextfos.beer.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alextfos.beer.domain.entity.BeerBo
import com.alextfos.beer.domain.usecase.SearchUseCase
import com.alextfos.punkoo.common.ext.splitBySpace
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): ViewModel() {

    var searchValue: String? by mutableStateOf(null)

    fun getPagedSearch(): Flow<PagingData<BeerBo>> {
        return searchUseCase.invoke(searchValue?.splitBySpace()).cachedIn(viewModelScope)
        //return searchUseCase.invoke(listOf("tyris")).cachedIn(viewModelScope)
    }
}
