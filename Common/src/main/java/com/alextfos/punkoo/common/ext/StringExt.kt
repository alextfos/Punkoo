package com.alextfos.punkoo.common.ext

fun List<String>.normalizeWithUnderScores(): String {
    val res = StringBuilder()
    map {
        res.append(it + "_")
    }
    res.delete(res.length - 1, res.length)
    return res.toString()
}

fun String.tokenize(): List<String> = split(" ")