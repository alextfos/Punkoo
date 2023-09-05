buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(buildLibs.buildTools)
        classpath(buildLibs.kotlinPlugin)
        classpath(androidLibs.hiltPlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
