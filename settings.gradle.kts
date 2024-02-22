pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        gradlePluginPortal()
    }
}

rootProject.name = "WahtsAppClone"
include(":app")
include(":auth:ui")
include(":auth:domain")
include(":auth:data")
include(":core:ui")
include(":core:data")
include(":core:domain")
