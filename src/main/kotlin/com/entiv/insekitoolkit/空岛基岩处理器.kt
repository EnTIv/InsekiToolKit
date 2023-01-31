package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerInteractEvent

/**
 * 允许玩家右键移除空岛的基岩
 */
object 空岛基岩处理器 : PluginModule, Listener {

    @EventHandler
    private fun onPlayerClick(event: PlayerInteractEvent) {
        val clickedBlock = event.clickedBlock ?: return
        val world = event.player.world

        if (world.name != "world_island") return
        if (clickedBlock.type != Material.BEDROCK) return

        clickedBlock.type = Material.AIR
    }

    @EventHandler
    private fun denyFly(event: PlayerChangedWorldEvent) {
        val player = event.player

        if (!player.isOp) {
            player.allowFlight = false
            player.isFlying = false
        }
    }
}

