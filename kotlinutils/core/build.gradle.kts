plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            groupId = "com.w2sv.kotlinutils"
            artifactId = "core"
            version = version.toString()
            afterEvaluate {
                from(components["java"])
            }
            pom {
                developers {
                    developer {
                        id.set("w2sv")
                        name.set("Janek Zangenberg")
                    }
                }
                description.set("Some generic kotlin utility methods.")
                url.set("https://github.com/w2sv/KotlinUtils")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }
}

dependencies {
    testImplementation(libs.junit)
}