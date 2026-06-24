pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        mavenLocal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven(url = "https://central.sonatype.com/repository/maven-snapshots/")
    }
    versionCatalogs {
        create("libs") {
            from("com.what3words:android-version-catalog:2026.06.01-SNAPSHOT")

            version("minSdk", "24")
        }
    }
}
rootProject.name = "android-design-library"
include(":design-library-usage-sample")
include(":design-library")
