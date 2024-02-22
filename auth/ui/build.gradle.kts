@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id(Plugins.COMMON)
}

android {
    namespace = "com.example.auth.ui"
}

dependencies {

    implementation(project(":auth:domain"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
}