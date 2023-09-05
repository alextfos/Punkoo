package com.alextfos.punkoo.common.ext

import com.alextfos.punkoo.common.domain.entity.Error
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.UnknownHostException


const val http404 = 404

fun Throwable.toError(): Error = when (this) {
    is IOException-> Error.Connectivity(this.message ?: "")
    is HttpException -> {
        if (this.code() == http404) {
            Error.EmptyView("${this.code()} - empty-view")
        } else {
            Error.Unknown("${code()} - this.message ?: ")
        }
    }
    is com.alextfos.punkoo.common.exception.EmptyListException -> Error.EmptyView(this.message ?: "")
    else -> Error.Unknown(this.message ?: "")
}

fun Throwable.logError() {
    Timber.e(this)
}