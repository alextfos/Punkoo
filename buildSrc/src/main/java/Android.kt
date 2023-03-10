import java.time.LocalDateTime
import java.time.format.DateTimeFormatter.ofPattern

object Android {

    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33
    val versionCode: Int = LocalDateTime.now().format(ofPattern("yyyyMMddHH")).toInt()
    const val versionName = "1.0"
}
