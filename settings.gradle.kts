pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven(url = "https://repo.maven.apache.org/maven2")
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            //library("activity", "androidx.activity:activity-compose:1.6.1")
            version("activity", "1.6.1")
            library(
                "activity",
                "androidx.activity",
                "activity-compose"
            ).versionRef("activity")
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
