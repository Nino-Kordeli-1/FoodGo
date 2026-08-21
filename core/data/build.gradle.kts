plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.foodgo.koin.library)
}
android {
    namespace = "com.foodgo.database"
    ksp{
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    api(projects.core.domain)
    implementation(projects.core.designsystem)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.androidx.annotation.experimental)

    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
}