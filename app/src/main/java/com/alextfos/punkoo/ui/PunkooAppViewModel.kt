package com.alextfos.punkoo.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.alextfos.punkoo.common.domain.entity.AppSession
import com.alextfos.punkoo.common.domain.usecase.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PunkooAppViewModel @Inject constructor(
    val session: AppSession,
) : ViewModel() {

    var initState by mutableStateOf(UiStateRemoteConfig())

    init {
        initSession()
    }

    fun initSession() {
        viewModelScope.launch {
            initState = UiStateRemoteConfig(loading = true)
            initState = UiStateRemoteConfig(result = Either.Right(null)) // TODO
        }
    }

    data class UiStateRemoteConfig(
        val loading: Boolean = false,
        val result: Result<AppSession?> = Either.Right(null)
    )
}
