import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.*

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.neoforged.net/releases")
        maven("https://maven.jab125.dev")
        maven("https://jitpack.io")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.jab125.preprocessor.preprocess" -> {
                    useModule("com.jab125.preprocessor:preprocessor:${requested.version}")
                }
            }
        }
    }
}

System.setProperty("rootDir", rootProject.projectDir.absolutePath.toString())

var properties: Properties = Properties()
val path: Path = Path.of(System.getProperty("rootDir")).resolve("gradle.properties")
properties.load(Files.newInputStream(path))

val loaders = properties["enabled_platforms"].toString().split(",")
if (!loaders.contains("fabric")) {
    throw RuntimeException("You can't remove Fabric!")
}

rootProject.name = "multiloader-example-mod"
rootProject.buildFileName = "root.gradle.kts"

loaders.forEach { loader ->
    include(":$loader")
    project(":$loader").apply {
        projectDir = file("versions/$loader")
        buildFileName = "../../build.gradle"
    }
}