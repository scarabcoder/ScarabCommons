package com.scarabcoder.commons.config

import com.google.common.base.CaseFormat
import com.scarabcoder.commons.ScarabCommons
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

abstract class Config(val location: File) {
    constructor(name: String) : this(File(ScarabCommons.thisPlugin.dataFolder, name + ".yml"))

    var saveOnUpdate = false

    init {
        if(!location.exists()) location.createNewFile()
    }

    internal val config: FileConfiguration by lazy {
        YamlConfiguration.loadConfiguration(location)
    }

    fun save() = config.save(location)


    fun reload() = config.load(location)
}

val String.configFriendlyName: String
    get() = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_HYPHEN, this.replace(" ", "-"))