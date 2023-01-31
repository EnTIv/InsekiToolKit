package com.entiv.insekitoolkit

import com.entiv.core.module.PluginModule
import com.entiv.core.plugin.InsekiPlugin
import org.bukkit.configuration.ConfigurationSection

sealed interface ConfigModule : PluginModule {
    val name: String
        get() = this::class.simpleName!!

    val section: ConfigurationSection
        get() = InsekiPlugin.config.getConfigurationSection(name) ?: error("模块 $name 未找到配置文件")
}