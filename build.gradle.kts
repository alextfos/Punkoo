buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(androidLibs.hiltPlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Build.kotlinVersion}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
