package com.alextfos.search.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alextfos.search.domain.entity.BeerBo
import com.alextfos.search.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): ViewModel() {

    fun getPagedSearch(): Flow<PagingData<BeerBo>> {
        return searchUseCase.invoke(
            listOf("tyris")
        ).cachedIn(viewModelScope)
    }
}
