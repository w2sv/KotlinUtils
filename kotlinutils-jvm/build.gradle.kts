plugins {
    id("w2sv.kmp-library")
}

kotlin {
    sourceSets {
        jvmMain.dependencies {}
        jvmTest.dependencies { implementation(kotlin("test")) }
    }
}
