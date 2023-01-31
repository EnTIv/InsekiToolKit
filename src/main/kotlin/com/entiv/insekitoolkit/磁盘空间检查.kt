package com.entiv.insekitoolkit

import com.entiv.core.debug.warn
import com.entiv.core.module.PluginModule
import com.entiv.core.plugin.InsekiPlugin
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitRunnable
import java.nio.file.FileSystems

/**
 * 磁盘空间检查，低于一定值就关服
 */
object 磁盘空间检查 : ConfigModule {

    private var checkTask: BukkitRunnable? = null

    override fun load() {
        checkTask = object : BukkitRunnable() {
            override fun run() {
                val fileSystems = FileSystems.getDefault()
                val property = System.getProperty("os.name").lowercase()

                val fileStores = when (val os = getOS(property)) {
                    "windows" -> fileSystems.fileStores
                    "linux" -> fileSystems.fileStores.filter { it.name().startsWith("/dev/sd") }
                    else -> error("暂未支持 $os 系统")
                }

                fileStores.forEach { fileStore ->
                    val avail = fileStore.usableSpace / 1024 / 1024 / 1024

                    if (avail > 3) return@forEach

                    repeat(10) {
                        warn("服务器磁盘 ${fileStore.name()} 空间小于 3G，已强制关服!")
                    }

                    Bukkit.shutdown()
                }
            }
        }
        checkTask!!.runTaskTimer(InsekiPlugin.plugin, 0, 60 * 20)
    }


    override fun unload() {
        checkTask?.cancel()
    }

    fun getOS(os: String): String {
        return if (os.contains("win")) {
            "windows"
        } else if (os.contains("mac")) {
            "mac"
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            "linux"
        } else {
            error("暂未支持 $os 系统")
        }
    }
}