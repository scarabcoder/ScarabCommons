package com.scarabcoder.commons

import net.md_5.bungee.api.ChatColor
import org.bukkit.entity.Player

fun String.colored(): String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

fun Collection<Player>.sendMessage(message: String) {
    forEach { it.sendMessage(message) }
}

val BLACK = ChatColor.BLACK
val DARK_BLUE = ChatColor.DARK_BLUE
val DARK_GREEN = ChatColor.DARK_GREEN
val DARK_AQUA = ChatColor.DARK_AQUA
val DARK_RED = ChatColor.DARK_RED
val DARK_PURPLE = ChatColor.DARK_PURPLE
val GOLD = ChatColor.GOLD
val GRAY = ChatColor.GRAY
val DARK_GRAY = ChatColor.DARK_GRAY
val BLUE = ChatColor.BLUE
val GREEN = ChatColor.GREEN
val AQUA = ChatColor.AQUA
val RED = ChatColor.RED
val LIGHT_PURPLE = ChatColor.LIGHT_PURPLE
val YELLOW = ChatColor.YELLOW
val WHITE = ChatColor.WHITE
val MAGIC = ChatColor.MAGIC
val BOLD = ChatColor.BOLD
val STRIKETHROUGH = ChatColor.STRIKETHROUGH
val UNDERLINE = ChatColor.UNDERLINE
val ITALIC = ChatColor.ITALIC
val RESET_COLOR = ChatColor.RESET