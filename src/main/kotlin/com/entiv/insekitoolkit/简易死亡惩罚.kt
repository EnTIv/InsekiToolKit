package com.entiv.insekitoolkit

import com.entiv.core.common.submit
import com.entiv.core.module.PluginModule
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object 简易死亡惩罚 : ConfigModule, Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private fun onPlayerRespawn(event: PlayerRespawnEvent) {
        val respawnLocation = event.respawnLocation
        val player = event.player

        if (respawnLocation.world.name == "world") {
            submit {
                player.health = 2.0
                player.foodLevel = 2
                player.saturation = 2f

                player.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 30 * 20, 0))
                player.addPotionEffect(PotionEffect(PotionEffectType.SLOW_DIGGING, 30 * 20, 0))
            }
        }
    }
}