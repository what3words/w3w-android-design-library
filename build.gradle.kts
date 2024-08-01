buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.3")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.0" apply false
    id("com.android.library") version "8.5.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("com.autonomousapps.dependency-analysis") version "1.20.0" apply true
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.sonarqube")
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.layout.buildDirectory)
 }