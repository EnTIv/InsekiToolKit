package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.event.player.PlayerPickupItemEvent

object 隐身无法拾取物品 : ConfigModule, Listener {

    @EventHandler
    private fun onProjectileHit(event: EntityPickupItemEvent) {
        val player = event.entity as? Player ?: return

        if (player.isInvisible) {
            event.isCancelled = true
        }
    }
}