plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.what3words.design.library"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 11
        versionName = "1.10"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        register("release") {
            storeFile = file("../.signing/release.jks")
            storePassword = "123456"
            keyAlias = "key0"
            keyPassword = "123456"

            // Optional, specify signing versions used
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
            setProguardFiles(listOf(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jvmToolchain.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvmToolchain.get())
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.what3words.design.library.sample"
}

dependencies {
    implementation(project(":design-library"))
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.navigation.compose)
}