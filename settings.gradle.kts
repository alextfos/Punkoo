pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven(url = "https://repo.maven.apache.org/maven2")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Punkoo"
include(":app")
include(":common")
include(":styles")
include(":beer")
