package com.entiv.insekitoolkit

import com.entiv.core.common.submit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

object 烟花补丁 : ConfigModule, Listener {

    @EventHandler(priority = EventPriority.LOW)
    private fun onPlayerUse(event: PlayerInteractEvent) {
        val itemStack = event.item ?: return
        val player = event.player
        val world = player.world

        if (itemStack.displayName.contains("一骑飞天") && world.name == "world") {

            val clone = itemStack.clone()
            itemStack.amount = 0

            event.isCancelled = true
            submit { player.inventory.addItem(clone) }
        }
    }
}