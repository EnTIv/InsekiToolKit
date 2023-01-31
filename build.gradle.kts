plugins {
    `maven-publish`
    kotlin("jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "com.entiv"
version = "1.0"

repositories {
    mavenLocal()
    mavenCentral()

    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://maven.enginehub.org/repo/") }
    maven { url = uri("https://repo.purpurmc.org/snapshots") }
    maven { url = uri("https://repo.codemc.org/repository/maven-public/") }
}

dependencies {
    implementation("com.entiv:insekicore:1.1.3")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.8")

    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly(kotlin("reflect"))

    compileOnly("org.purpurmc.purpur", "purpur-api", "1.19-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.0")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.10.0")
    compileOnly("com.github.LoneDev6:api-itemsadder:3.0.0")
    compileOnly("com.zaxxer:HikariCP:5.0.1")
    compileOnly(fileTree("libs"))
}

tasks {

    shadowJar {
        project.findProperty("outputPath")?.let {
            destinationDirectory.set(file(it.toString()))
        }

        archiveFileName.set("${project.name}-${project.version}.jar")
        relocate("com.entiv.core", "${project.group}.lib.core")

        println("导出路径: ${destinationDirectory.get()}")
        println("")
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(
                "name" to project.name.toLowerCase(),
                "version" to project.version
            )
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

