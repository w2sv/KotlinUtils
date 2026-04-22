plugins {
    `kotlin-dsl`
    alias(libs.plugins.ktlint)
}

dependencies {
    implementation(plugin(libs.plugins.kmp))
    implementation(plugin(libs.plugins.ktlint))
    implementation(plugin(libs.plugins.vanniktech.maven.publish))
}

private fun plugin(dependency: Provider<PluginDependency>): Provider<String> =
    dependency.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }
