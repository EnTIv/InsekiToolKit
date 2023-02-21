package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.checkerframework.checker.units.qual.C

object 虚空掉落检查 : ConfigModule, Listener {

    @EventHandler
    private fun onPlayerDamage(event: EntityDamageEvent) {
        val player = event.entity as? Player ?: return

        val world = player.world
        val cause = event.cause

        if (world.name != "world_island") return

        if (cause != EntityDamageEvent.DamageCause.VOID) return

        player.addPotionEffect(PotionEffect(PotionEffectType.SLOW_FALLING, 5, 0))
        player.performCommand("is")

        event.isCancelled = true
    }
}