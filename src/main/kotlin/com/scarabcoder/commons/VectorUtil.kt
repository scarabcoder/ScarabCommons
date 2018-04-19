package com.scarabcoder.commons

import org.apache.commons.lang3.math.NumberUtils
import org.bukkit.Location
import org.bukkit.util.Vector


operator fun Vector.component1(): Double = this.x
operator fun Vector.component2(): Double = this.y
operator fun Vector.component3(): Double = this.z


fun Vector.add(number: Number): Vector {
    val number = number.toDouble()
    this.x += number
    this.y += number
    this.z += number
    return this
}

fun Vector.subtract(number: Number): Vector {
    val number = number.toDouble()
    this.x -= number
    this.y -= number
    this.z -= number
    return this
}

fun Vector.divide(number: Number): Vector {
    val number = number.toDouble()
    this.x /= number
    this.y /= number
    this.z /= number
    return this
}


operator fun Vector.plus(other: Vector): Vector = this.clone().add(other)
operator fun Vector.minus(other: Vector): Vector = this.clone().add(other)
operator fun Vector.div(other: Vector): Vector = this.clone().divide(other)
operator fun Vector.times(other: Vector): Vector = this.clone().multiply(other)
operator fun Vector.plus(other: Number): Vector = this.clone().add(other)
operator fun Vector.minus(other: Number): Vector = this.clone().subtract(other)
operator fun Vector.div(other: Number): Vector = this.clone().divide(other)
operator fun Vector.times(other: Double): Vector = this.clone().multiply(other)



fun Location.minMax(other: Location): Pair<Location, Location> {
    val loc1 = this.clone()
    val loc2 = this.clone()
    loc1.x = NumberUtils.min(this.x, other.x)
    loc2.x = NumberUtils.max(this.x, other.x)
    loc1.y = NumberUtils.min(this.y, other.y)
    loc2.y = NumberUtils.max(this.y, other.y)
    loc1.z = NumberUtils.min(this.z, other.z)
    loc2.z = NumberUtils.max(this.z, other.z)
    return Pair(loc1, loc2)
}

fun Vector.minMax(other: Vector): Pair<Vector, Vector> {
    val loc1 = this.clone()
    val loc2 = this.clone()
    loc1.x = NumberUtils.min(this.x, other.x)
    loc2.x = NumberUtils.max(this.x, other.x)
    loc1.y = NumberUtils.min(this.y, other.y)
    loc2.y = NumberUtils.max(this.y, other.y)
    loc1.z = NumberUtils.min(this.z, other.z)
    loc2.z = NumberUtils.max(this.z, other.z)
    return Pair(loc1, loc2)

}

fun Pair<Location, Location>.isInArea(location: Location): Boolean {
    val l1 = first
    val l2 = second
    return (location.x in l1.x..l2.x &&
            location.y in l1.y..l2.y &&
            location.z in l1.z..l2.z)
}