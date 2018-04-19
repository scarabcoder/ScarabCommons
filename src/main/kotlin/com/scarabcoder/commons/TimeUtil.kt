package com.scarabcoder.commons

import java.util.concurrent.TimeUnit

fun formatTime(format: String, period: Long, minutePlaceholder: String, secondPlaceholder: String): String {

    val ms = TimeUnit.MILLISECONDS
    val minutes = ms.toMinutes(period)

    val seconds = ms.toSeconds(period) - TimeUnit.MINUTES.toSeconds(ms.toMinutes(period))

    return format.replace(minutePlaceholder, minutes.toString()).replace(secondPlaceholder, seconds.toString())

}