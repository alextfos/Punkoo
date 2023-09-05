import org.gradle.api.JavaVersion
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

object PunkooProject {

    const val applicationId = "com.alextfos.punkoo"
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
    const val versionName = "1.0"
    val versionCode: Int = LocalDateTime.now().format(ofPattern("yyyyMMddHH")).toInt()

    val javaVersion = JavaVersion.VERSION_1_8
    const val composeCompilerVersion = "1.3.2"
}
