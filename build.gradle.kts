// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        // jReleaser pulls in jaxb-runtime whose com.sun.xml.bind classes reference
        // javax.activation.DataSource, which is absent on JDK 17+. Provide it so AGP's
        // SDK XML parsing keeps working.
        classpath("com.sun.activation:javax.activation:1.2.0")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.dokka) apply false
    alias(libs.plugins.jreleaser) apply false
    alias(libs.plugins.sonarqube) apply false
    alias(libs.plugins.autonomousapps.dependency.analysis)
}

allprojects {
    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.layout.buildDirectory)
}