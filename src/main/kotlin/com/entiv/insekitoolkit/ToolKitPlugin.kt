package com.entiv.insekitoolkit

import com.entiv.core.plugin.InsekiPlugin

class ToolKitPlugin : InsekiPlugin() {

    override fun onEnabled() {
        loadModules()
    }

    private fun loadModules() {
        moduleManager.load(简易死亡惩罚)
        moduleManager.load(空岛基岩处理器)
        moduleManager.load(虚空掉落检查)
        moduleManager.load(地狱门处理器)
        moduleManager.load(磁盘空间检查)
        moduleManager.load(游戏规则管理)
        moduleManager.load(绑定诅咒补丁)
        moduleManager.load(烟花补丁)
    }
}