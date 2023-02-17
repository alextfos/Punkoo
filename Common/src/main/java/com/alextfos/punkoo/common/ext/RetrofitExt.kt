package com.alextfos.punkoo.common.data.extensions

import retrofit2.HttpException
import retrofit2.Response

inline fun <reified T> Response<T>.safeBody(): T {
    if (isSuccessful) {
        body()?.let {
            return it
        }
    }
    throw HttpException(this)
}
