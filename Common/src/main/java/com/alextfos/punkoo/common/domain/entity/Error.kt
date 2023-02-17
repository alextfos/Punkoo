package com.alextfos.punkoo.common.domain.entity

sealed class Error(val message: String) {
    class EmptyView(message: String) : Error(message)
    class Connectivity(message: String) : Error(message)
    class Unknown(message: String) : Error(message)
}