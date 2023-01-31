package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent

object 展示框保护 : ConfigModule, Listener {

    @EventHandler
    private fun onProjectileHit(event: ProjectileHitEvent) {
        println(event.hitEntity)
    }

}