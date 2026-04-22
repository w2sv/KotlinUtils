plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jlleitschuh.gradle.ktlint")
    id("com.vanniktech.maven.publish")
}

kotlin {
    jvmToolchain(11)
    jvm()
}

mavenPublishing {
    // Use module name as artifactId
    coordinates(
        artifactId = project.name,
        version = rootProject.version.toString()
    )
}
