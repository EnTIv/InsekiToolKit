package com.entiv.insekitoolkit

import com.entiv.core.plugin.InsekiPlugin

class ToolKitPlugin : InsekiPlugin() {

    override fun onEnabled() {
        loadModules()
    }

    private fun loadModules() {
        moduleManager.load(绑定诅咒补丁)
        moduleManager.load(展示框保护)
    }
}