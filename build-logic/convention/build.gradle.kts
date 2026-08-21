import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
    alias(libs.plugins.android.lint)
}

group = "com.foodgo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("root") {
            id = "foodgo.root"
            implementationClass = "com.RootPlugin"
        }
        register("koinLibrary") {
            id = "foodgo.koin.library"
            implementationClass = "com.KoinConventionPlugin"
        }
        register("jvmLibrary") {
            id = "foodgo.jvm.library"
            implementationClass = "com.JvmLibraryConventionPlugin"
        }
        register("androidLibrary") {
            id = "foodgo.android.library"
            implementationClass = "com.AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "foodgo.android.application"
            implementationClass = "com.AndroidApplicationConventionPlugin"
        }

        register("androidFeature") {
            id = "foodgo.android.feature"
            implementationClass = "com.AndroidFeatureConventionPlugin"
        }

        register("androidCompose") {
            id = "foodgo.android.compose"
            implementationClass = "com.AndroidComposeConventionPlugin"
        }
    }
}