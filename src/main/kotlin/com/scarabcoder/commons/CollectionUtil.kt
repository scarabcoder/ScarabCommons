package com.scarabcoder.commons

import org.bukkit.util.Vector
import java.util.concurrent.ThreadLocalRandom

/**
 * Get a random element from the list using ThreadLocalRandom.
 */
fun <T> List<T>.random(): T {
    if(this.isEmpty()) throw IllegalAccessException("Collection is empty!")
    return this[ThreadLocalRandom.current().nextInt(0, this.size)]
}

fun <E> Collection<E>.nextElement(current: E): Pair<Int, E> {
    if(!this.contains(current)) throw IllegalArgumentException("Collection does not contain element $current!")
    return Pair(indexOf(current) % size, elementAt((indexOf(current) + 1) % size))
}

fun <E> Collection<E>.previousElement(current: E): Pair<Int, E> {
    if(!this.contains(current)) throw IllegalArgumentException("Collection does not contain element $current!")
    return Pair(indexOf(current) % size, elementAt((indexOf(current) - 1) % size))
}
fun Vector.iterate(max: Vector): Iterator<Vector> {
    val items = ArrayList<Vector>()
    for(x in this.x.toInt()..max.x.toInt()){
        for(y in this.y.toInt()..max.y.toInt()){
            for(z in this.z.toInt()..max.z.toInt()){
                items.add(Vector(x, y, z))
            }
        }
    }
    return items.iterator()
}


fun <E> List<E>.subList(startIndex: Int): List<E> {
    return this.subList(startIndex, this.size)
}