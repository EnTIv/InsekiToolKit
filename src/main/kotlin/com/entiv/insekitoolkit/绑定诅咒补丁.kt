package com.entiv.insekitoolkit

import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareAnvilEvent

object 绑定诅咒补丁 : ConfigModule, Listener {
    @EventHandler
    fun onEnchant(event: PrepareAnvilEvent) {
        val result = event.result ?: return
        val player = event.view.player as? Player ?: return

        if (result.type.maxDurability.toInt() == 0 && result.enchantments.containsKey(Enchantment.BINDING_CURSE)) {
            val itemMeta = result.itemMeta
            itemMeta.removeEnchant(Enchantment.BINDING_CURSE)
            result.itemMeta = itemMeta
            event.result = result
            player.updateInventory()
        }
    }
}