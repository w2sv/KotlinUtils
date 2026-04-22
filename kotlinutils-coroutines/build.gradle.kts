plugins {
    id("w2sv.kotlin-library")
}

dependencies {
    implementation(project(":kotlinutils-core"))
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
}
