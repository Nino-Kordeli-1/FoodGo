plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
}

android {
    namespace = "com.foodgo.ui"
}

dependencies {
    api(projects.core.designsystem)
    api(projects.core.domain)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(projects.core.navigation)

    implementation(libs.coil.compose)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.compose.material3)
}