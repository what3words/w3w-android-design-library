import java.net.URI

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.dokka") version "1.9.10"
    id("maven-publish")
    id("signing")
    id("org.jreleaser")
    id("org.jetbrains.kotlin.plugin.compose")
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
    compileSdk = 35

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        abortOnError = false
        warningsAsErrors = false
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
    namespace = "com.what3words.design.library"
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2025.05.00"))
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.1")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.airbnb.android:lottie-compose:6.4.1")
    implementation("androidx.core:core-ktx:1.16.0")
    debugImplementation("androidx.compose.ui:ui-tooling")
    api("androidx.compose.material:material-icons-extended")
}

//region publishing
publishing {
    publications {
        create<MavenPublication>("maven") {
            afterEvaluate {
                from(components["release"])
            }

            groupId = "com.what3words"
            artifactId = "w3w-android-design-library"
            version = project.version.toString()

            withType(MavenPublication::class.java) {
                val publicationName = name
                val dokkaJar =
                    project.tasks.register("${publicationName}DokkaJar", Jar::class) {
                        group = JavaBasePlugin.DOCUMENTATION_GROUP
                        description = "Assembles Kotlin docs with Dokka into a Javadoc jar"
                        archiveClassifier.set("javadoc")
                        from(tasks.named("dokkaHtml"))

                        // Each archive name should be distinct, to avoid implicit dependency issues.
                        // We use the same format as the sources Jar tasks.
                        // https://youtrack.jetbrains.com/issue/KT-46466
                        archiveBaseName.set("${archiveBaseName.get()}-$publicationName")
                    }
                artifact(dokkaJar)
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
            // POM metadata
        }
    }

    repositories {
        maven {
            name = "sonatypeSnapshots"
            url = uri("https://central.sonatype.com/repository/maven-snapshots/")
            credentials {
                username = findProperty("MAVEN_CENTRAL_USERNAME") as? String
                password = findProperty("MAVEN_CENTRAL_PASSWORD") as? String
            }
        }
        maven {
            name = "stagingLocal"
            url = uri(layout.buildDirectory.dir("staging-deploy").get().asFile.absolutePath)
        }
    }
}

jreleaser {
    release {
        github {
            repoOwner = "what3words"
            overwrite = true
        }
    }

    signing {
        active.set(org.jreleaser.model.Active.ALWAYS)
        armored.set(true)
        publicKey.set(findProperty("W3W_GPG_PUBLIC_KEY")?.toString())
        secretKey.set(findProperty("W3W_GPG_SECRET_KEY")?.toString())
        passphrase.set(findProperty("W3W_GPG_PASSPHRASE")?.toString())
    }
    deploy {
        maven {
            mavenCentral {
                create("sonatype") {
                    active.set(org.jreleaser.model.Active.ALWAYS)
                    url.set("https://central.sonatype.com/api/v1/publisher")
                    stagingRepository(layout.buildDirectory.dir("staging-deploy").get().asFile.absolutePath)
                    username.set(findProperty("MAVEN_CENTRAL_USERNAME")?.toString())
                    password.set(findProperty("MAVEN_CENTRAL_PASSWORD")?.toString())
                    verifyPom.set(false)
                    setStage(org.jreleaser.model.api.deploy.maven.MavenCentralMavenDeployer.Stage.UPLOAD.toString())
                }
            }
        }
    }
}
//endregion