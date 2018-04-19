package com.scarabcoder.commons

import java.text.DecimalFormat


fun Int.constrain(min: Int, max: Int): Int {
    return when {
        this < min -> min
        this > max -> max
        else -> this
    }
}
fun Int.constrainMax(max: Int): Int = if(this > max) max else this

fun Int.constrainMin(min: Int): Int = if(this < min) min else this

fun Number.format(format: String): String = DecimalFormat(format).format(this)