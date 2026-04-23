# KotlinUtils

![Maven Central Version](https://img.shields.io/maven-central/v/io.github.w2sv/kotlinutils-core)
![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/w2sv/KotlinUtils?include_prereleases)
[![Build](https://github.com/w2sv/KotlinUtils/actions/workflows/workflow.yaml/badge.svg)](https://github.com/w2sv/KotlinUtils/actions/workflows/workflow.yaml)
![GitHub](https://img.shields.io/github/license/w2sv/KotlinUtils)

A lightweight collection of Kotlin utilities with a focus on **clean APIs**, **multiplatform support**, and **minimal dependencies**.

---

## 📦 Modules

| Artifact | Targets | Description |
|--------|--------|------------|
| `kotlinutils-core` | JVM, iOS | General-purpose utilities |
| `kotlinutils-coroutines` | JVM, iOS | Extensions for `kotlinx.coroutines` APIs |
| `kotlinutils-jvm` | JVM | JVM-specific utilities (targetting e.g. `Date`, `LocalDateTime`, `Duration`) |

---

## 🚀 Installation

### Inline

```kotlin
dependencies {
    implementation("io.github.w2sv:kotlinutils-core:<version>")
    implementation("io.github.w2sv:kotlinutils-coroutines:<version>")
    implementation("io.github.w2sv:kotlinutils-jvm:<version>")
}
```

---

### Version Catalog (`libs.versions.toml`)

```toml
[versions]
w2sv-kotlinutils = "<version>"

[libraries]
w2sv-kotlinutils-core = { module = "io.github.w2sv:kotlinutils-core", version.ref = "w2sv-kotlinutils" }
w2sv-kotlinutils-coroutines = { module = "io.github.w2sv:kotlinutils-coroutines", version.ref = "w2sv-kotlinutils" }
w2sv-kotlinutils-jvm = { module = "io.github.w2sv:kotlinutils-jvm", version.ref = "w2sv-kotlinutils" }
```

**build.gradle.kts:**

```kotlin
dependencies {
    implementation(libs.w2sv.kotlinutils.core)
    implementation(libs.w2sv.kotlinutils.coroutines)
    implementation(libs.w2sv.kotlinutils.jvm)
}
```

---

Use only what you need — modules are intentionally split to keep dependencies minimal.

## 📄 License

Licensed under the Apache License 2.0.
