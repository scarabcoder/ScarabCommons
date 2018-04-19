package com.scarabcoder.commons

import org.bukkit.scheduler.BukkitRunnable

typealias Action = BukkitRunnable.() -> Unit

private fun prepareRunnable(action: Action): BukkitRunnable {
    return object: BukkitRunnable() {
        override fun run() {
            this.action()
        }
    }
}

/**
 * Run a task asynchronously via the Bukkit Scheduler.
 */
fun doAsync(func: Action) = prepareRunnable(func).runTaskAsynchronously(ScarabCommons.thisPlugin)

/**
 * Run a non-asynchronous task periodically with a delay
 */
fun doTimer(delay: Long, period: Long, action: Action) = prepareRunnable(action).runTaskTimer(ScarabCommons.thisPlugin, delay, period)

/**
 * Run a non-asynchronous task periodically.
 */
fun doTimer(period: Long, action: Action) = doTimer(period, period, action)

/**
 * Run an asynchronous task periodically with a delay.
 */
fun doAsyncTimer(delay: Long, period: Long, action: Action) = prepareRunnable(action).runTaskTimerAsynchronously(ScarabCommons.thisPlugin, delay, period)

/**
 * Run an asynchronous task periodically.
 */
fun doAsyncTimer(period: Long, action: Action) = doAsyncTimer(period, period, action)

/**
 * Run a non-asynchronous task later.
 */
fun doLater(delay: Long, action: Action) = prepareRunnable(action).runTaskLater(ScarabCommons.thisPlugin, delay)

/**
 * Run an asynchronous task later.
 */
fun doLaterAsync(delay: Long, action: Action) = prepareRunnable(action).runTaskLaterAsynchronously(ScarabCommons.thisPlugin, delay)

/**
 * Run a sync task in the main thread.
 */
fun task(action: Action) = prepareRunnable(action).runTask(ScarabCommons.thisPlugin)
