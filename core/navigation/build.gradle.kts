plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.foodgo.navigation"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.lifecycle.viewModel.navigation3)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
