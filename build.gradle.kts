buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.8.2")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.3")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.8.2" apply false
    id("com.android.library") version "8.8.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("com.autonomousapps.dependency-analysis") version "1.20.0" apply true
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("org.jreleaser") version "1.17.0" apply false
}

allprojects {
    apply(plugin = "org.sonarqube")
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.layout.buildDirectory)
 }