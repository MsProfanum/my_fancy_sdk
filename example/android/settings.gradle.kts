pluginManagement {
    val flutterSdkPath = run {
        val properties = java.util.Properties()
        file("local.properties").inputStream().use { properties.load(it) }
        val flutterSdkPath = properties.getProperty("flutter.sdk")
        require(flutterSdkPath != null) { "flutter.sdk not set in local.properties" }
        flutterSdkPath
    }

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.flutter.flutter-plugin-loader") version "1.0.0"
    //TODO: Change so that it's toml compatible - ${libs.versions.agp.get()}
    id("com.android.application") version "8.7.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.android.library") version "8.7.2" apply false
    id("androidx.privacysandbox.library") version "1.0.0-alpha02" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.10" apply false
}
include(":app")
include(":runtime-aware-sdk")
project(":runtime-aware-sdk").projectDir = File("../../android/runtime-aware-sdk")
include(":runtime-enabled-sdk")
project(":runtime-enabled-sdk").projectDir = File("../../android/runtime-enabled-sdk")
include(":runtime-enabled-sdk-bundle")
project(":runtime-enabled-sdk-bundle").projectDir = File("../../android/runtime-enabled-sdk-bundle")