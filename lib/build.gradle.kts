plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`
}

kotlin {
    jvmToolchain(17)
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

//            afterEvaluate {
//                from(components["release"])
//            }
        }
    }
}

dependencies {
    testImplementation(libs.junit)
}