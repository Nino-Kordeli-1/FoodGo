plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
}

android {
    namespace = "com.foodgo.designsystem"

}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}