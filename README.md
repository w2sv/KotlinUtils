# KotlinUtils

![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/w2sv/KotlinUtils?include_prereleases)
[![](https://jitpack.io/v/w2sv/KotlinUtils.svg)](https://jitpack.io/#w2sv/KotlinUtils)
[![Build](https://github.com/w2sv/KotlinUtils/actions/workflows/workflow.yaml/badge.svg)](https://github.com/w2sv/KotlinUtils/actions/workflows/workflow.yaml)
![GitHub](https://img.shields.io/github/license/w2sv/KotlinUtils)

A collection of JVM Kotlin utilities. Duh.

## Installation with gradle & jitpack

Add the Jitpack repository in your build configuration:

```kotlin
repositories {
    maven("https://jitpack.io")
}
```

Add the dependency:

```kotlin
dependencies {
    implementation("com.github.w2sv.KotlinUtils:core:version")
    implementation("com.github.w2sv.KotlinUtils:coroutines:version")

    // Or get the latest snapshot of a certain branch:
    implementation("com.github.w2sv.KotlinUtils:artefact:branchname-snapshot")
}
```

## License

```
MIT License

Copyright (c) 2022 Janek Zangenberg

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
