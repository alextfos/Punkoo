package com.alextfos.punkoo.common.domain.usecase

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.alextfos.punkoo.common.domain.entity.Error
import com.alextfos.punkoo.common.ext.toError
import timber.log.Timber

typealias Result<T> = Either<Error, T>

inline fun <T> runUseCase(body: () -> T): Result<T> = try {
    body().right()
} catch (t: Throwable) {
    Timber.e(t)
    t.toError().left()
}
