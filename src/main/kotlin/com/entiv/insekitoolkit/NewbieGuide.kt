package com.entiv.insekitoolkit

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerTeleportEvent

object NewbieGuide : ConfigModule, Listener {
    @EventHandler
    private fun denyTeleport(event: PlayerTeleportEvent) {

    }
}