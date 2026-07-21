import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SourcesJar

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.dokka)
    alias(libs.plugins.vanniktech.maven.publish)
}

group = "com.what3words"

/**
 * IS_SNAPSHOT_RELEASE property will be automatically added to the root gradle.properties file by the CI pipeline, depending on the GitHub branch.
 * A snapshot release is generated for every pull request merged or commit made into an epic branch.
 */
val isSnapshotRelease = findProperty("IS_SNAPSHOT_RELEASE") == "true"
version =
    if (isSnapshotRelease) "${findProperty("LIBRARY_VERSION")}-SNAPSHOT" else "${findProperty("LIBRARY_VERSION")}"


android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
        }
    }
    
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jvmToolchain.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvmToolchain.get())
    }
    lint {
        abortOnError = false
        warningsAsErrors = false
    }
    namespace = "com.what3words.design.library"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.core.ktx)
    debugImplementation(libs.androidx.compose.ui.tooling)
    api(libs.compose.material.icons)
}

//region publishing
mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("com.what3words", "w3w-android-design-library", version.toString())

    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = SourcesJar.Sources(),
            javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationHtml"),
        )
    )

    pom {
        name.set("w3w-android-design-library")
        description.set("Android design library for what3words apps and components with MaterialTheme and W3WTheme")
        url.set("https://github.com/what3words/w3w-android-design-library")
        licenses {
            license {
                name.set("The MIT License (MIT)")
                url.set("https://github.com/what3words/w3w-android-design-library/blob/master/LICENSE")
            }
        }
        developers {
            developer {
                id.set("what3words")
                name.set("what3words")
                email.set("development@what3words.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/what3words/w3w-android-design-library.git")
            developerConnection.set("scm:git:ssh://git@github.com:what3words/w3w-android-design-library.git")
            url.set("https://github.com/what3words/w3w-android-design-library/tree/master")
        }
    }
}
//endregion