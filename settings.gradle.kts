pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven(url = "https://repo.maven.apache.org/maven2")
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("androidLibs") {
            from(files("./gradle/androidLibs.versions.toml"))
        }
    }
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
