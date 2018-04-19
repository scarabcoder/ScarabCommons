package com.scarabcoder.commons

import com.google.common.io.ByteStreams
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import kotlin.concurrent.thread

/**
 * Sends a player to a different Bungee server, if it takes longer than @param [timeout] in ms (default 500) the player is kicked from the server instead
 * with the kick message @param [kickMessage]
 * Must be run in a thread different from the Bukkit server in order to check a player's connection status.
 * @throws [IllegalAccessException] if calling from the primary thread.
 */
fun Player.sendToServerOrKick(server: String, kickMessage: String, timeout: Int = 500) {
    if(Bukkit.isPrimaryThread()) throw IllegalAccessException("Cannot use this function in the main thread!")
    val out = ByteStreams.newDataOutput()
    out.writeUTF("Connect")
    out.writeUTF(server)

    this.sendPluginMessage(ScarabCommons.thisPlugin as Plugin, "BungeeCord", out.toByteArray())
    val uuid = this.uniqueId
    val time = System.currentTimeMillis()
    var done = false
    while(true){
        if(Bukkit.getPlayer(uuid) == null){
            break
        }else if(System.currentTimeMillis() - time >= timeout){
            task {
                if(Bukkit.getPlayer(uuid) != null)
                    Bukkit.getPlayer(uuid).kickPlayer(kickMessage)
                return@task
            }
        }
    }
}

fun generateEmptyWorld(name: String): World {
    val wc = WorldCreator(name)
    wc.type(WorldType.FLAT)
    wc.generatorSettings("2;0;1;")
    return wc.createWorld()
}

fun Collection<Player>.sendToServerOrKick(server: String, kickMessage: String, timeout: Int, callback: () -> Unit) {
    val copy = this.toList().map { it.uniqueId }
    doAsync {
        var kicked = 0
        thread {

            val it = copy.iterator()
            while(it.hasNext()) {

                val next = it.next()
                Bukkit.getPlayer(next).sendToServerOrKick(server, kickMessage, timeout)
                kicked++
            }
        }
        while(kicked < copy.size) {}
        task {
            callback.invoke()
        }
    }
}

fun Listener.register(plugin: JavaPlugin) {
    Bukkit.getPluginManager().registerEvents(this, plugin)
}