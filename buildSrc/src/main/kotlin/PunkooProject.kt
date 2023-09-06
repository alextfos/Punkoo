import org.gradle.api.JavaVersion
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

object PunkooProject {

    const val APPLICATION_ID = "com.alextfos.punkoo"

    // AndroidSDK
    const val MIN_SDK = 23
    const val ANDROID_SDK = 34

    // App versioning
    const val VERSION_NAME = "1.0"
    val versionCode: Int = LocalDateTime.now().format(ofPattern("yyyyMMddHH")).toInt()

    // Compile config
    val javaVersion = JavaVersion.VERSION_17
    const val COMPOSE_COMPILER_VERSION = "1.5.3"
}
