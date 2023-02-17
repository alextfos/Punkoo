buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.navigationGradlePlugin)
        classpath(Build.hiltAndroid)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

fun getSecretValueFromKey(key: String): String? {
    val keyFile = file("local.properties")
    val secretKeys = java.util.Properties()
    secretKeys.load(java.io.FileInputStream(keyFile))
    return secretKeys.getProperty(key)
}