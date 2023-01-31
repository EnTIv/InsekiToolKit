package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerPortalEvent

/*
* 将空岛，资源区，和地狱的地狱门传送改为随机传送
* */
object 地狱门处理器 : ConfigModule, Listener {

    @EventHandler
    private fun onEnterPortal(event: PlayerPortalEvent) {
        val player = event.player
        val toWorld = event.to.world

        when (toWorld.name) {
            "world" -> player.performCommand("rtp world world_resource")
            "world_nether" -> player.performCommand("rtp world world_nether")
            else -> return
        }

        event.isCancelled = true
    }
}