package com.entiv.insekitoolkit

import com.entiv.core.plugin.InsekiPlugin

class ToolKitPlugin : InsekiPlugin() {

    override fun onEnabled() {
        saveDefaultConfig()

        loadModules()
    }

    private fun loadModules() {
        moduleManager.load(绑定诅咒补丁)
        moduleManager.load(展示框保护)
        moduleManager.load(隐身无法拾取物品)
    }
}