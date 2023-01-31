package com.entiv.insekitoolkit

import com.Zrips.CMI.CMI
import com.entiv.core.module.PluginModule
import org.bukkit.Bukkit


object BetterHome : ConfigModule {

    override fun load() {
        val player = Bukkit.getPlayer("EnTIv")
        val user = CMI.getInstance().playerManager.getUser(player)

        user.homes.values.map { it.loc }
    }
}