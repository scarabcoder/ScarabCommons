package com.scarabcoder.commons.config

import org.bukkit.Location
import org.bukkit.configuration.ConfigurationSection

fun ConfigurationSection.getLocation(key: String): Location {
    return this.get(key) as Location
}

fun ConfigurationSection.setLocation(key: String, location: Location) {
    this.set(key, location)
}

fun <T> ConfigurationSection.getTypedList(key: String): List<T> {
    return getList(key) as List<T>
}