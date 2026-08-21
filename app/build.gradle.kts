plugins {
    alias(libs.plugins.foodgo.android.application)
}

android {
    namespace = "com.foodgo"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)
    implementation(projects.feature.menu)
    implementation(projects.feature.cart)
    implementation(projects.core.ui)
    implementation(projects.core.data)

    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewModel.navigation3)
}