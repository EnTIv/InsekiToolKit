package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.GameRule
import org.bukkit.World
import org.bukkit.event.EventHandler

/**
 * 控制世界游戏规则
 */
object 游戏规则管理 : ConfigModule {

    private val resourceWorld = listOf("world_resource", "world_nether", "world_the_end")

    override fun load() {
        Bukkit.getWorlds().forEach {
            applyGameRule(it)
        }
    }

    private fun applyGameRule(world: World) {
        world.difficulty = Difficulty.HARD

        world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
        world.setGameRule(GameRule.KEEP_INVENTORY, true)
        world.setGameRule(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, true)

        if (!isResourceWorld(world)) {
            world.setGameRule(GameRule.DO_MOB_SPAWNING, false)
            world.setGameRule(GameRule.DISABLE_RAIDS, true)
        }
    }

    private fun isResourceWorld(world: World) = resourceWorld.contains(world.name)

    @EventHandler
    private fun onWorldLoad(world: World) {
        applyGameRule(world)
    }
}