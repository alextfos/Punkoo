import org.gradle.api.JavaVersion
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

object PunkooProject {

    const val applicationId = "com.alextfos.punkoo"

    // AndroidSDK
    const val minSdk = 23
    const val androidSdk = 34

    // App versioning
    const val versionName = "1.0"
    val versionCode: Int = LocalDateTime.now().format(ofPattern("yyyyMMddHH")).toInt()

    // Compile config
    val javaVersion = JavaVersion.VERSION_17
    const val composeCompilerVersion = "1.5.3"
}
