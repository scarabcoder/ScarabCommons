package com.scarabcoder.commons.config

import kotlin.reflect.KProperty

class ConfigValue<T>(val default: T, val path: String? = null) {


    operator fun getValue(thisRef: Config, property: KProperty<*>): T {
        if(!thisRef.config.contains(property.name.configFriendlyName)){
            setValue(thisRef, property, default)
            return default
        }

        return thisRef.config.get(getPath(property)) as T
    }

    operator fun setValue(thisRef: Config, property: KProperty<*>, value: T) {
        thisRef.config.set(getPath(property), value)
        if(thisRef.saveOnUpdate) thisRef.save()
    }

    fun getPath(prop: KProperty<*>): String {
        return path ?: prop.name.configFriendlyName
    }

}

