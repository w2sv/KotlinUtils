plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    `maven-publish`
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "com.w2sv.kotlinutils"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
    buildFeatures {
        buildConfig = false
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.w2sv.kotlinutils"
            artifactId = "kotlinutils"
            version = version.toString()
            pom {
                developers {
                    developer {
                        id.set("w2sv")
                        name.set("Janek Zangenberg")
                    }
                }
                description.set("Generic kotlin utils.")
                url.set("https://github.com/w2sv/KotlinUtils")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {
    testImplementation(libs.junit)
}