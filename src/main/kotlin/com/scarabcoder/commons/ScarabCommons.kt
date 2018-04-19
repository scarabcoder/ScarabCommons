package com.scarabcoder.commons

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.InputStreamReader

object ScarabCommons {

    var thisPlugin: JavaPlugin

    init {
        val yml = YamlConfiguration.loadConfiguration(InputStreamReader(this::class.java.getResourceAsStream("/plugin.yml")))
        val plClazz = Class.forName(yml.getString("main")) as Class<JavaPlugin>
        thisPlugin = JavaPlugin.getPlugin(plClazz)
    }

}