plugins {
    id("w2sv.kmp-library")
}

kotlin {
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {}
        commonTest.dependencies { implementation(kotlin("test")) }
    }
}
