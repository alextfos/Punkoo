object Build {
    private const val androidBuildToolsVersion = "8.1.1"
    private const val hiltVersion = "2.44.2"

    const val kotlinVersion = "1.7.20"
    const val composeCompilerVersion = "1.3.2"

    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${hiltVersion}"
}