plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.vanniktech.maven.publish")
}

kotlin {
    jvmToolchain(11)
}

mavenPublishing {
    // Use module name as artifact id
    coordinates(
        version = rootProject.version.toString(),
        artifactId = path
    )
}
