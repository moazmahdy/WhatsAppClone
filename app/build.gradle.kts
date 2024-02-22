@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = BuildConfig.COMPILE_SDK

    defaultConfig {
        applicationId = BuildConfig.APP_ID
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        versionCode = BuildConfig.VERSION_CODE
        versionName = BuildConfig.VERSION_NAME

        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = BuildConfig.JAVA_VERSION_NAME
        targetCompatibility = BuildConfig.JAVA_VERSION_NAME
    }
    kotlinOptions {
        jvmTarget = BuildConfig.JAVA_VERSION_NAME.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildConfig.KOTLIN_COMPILER_EXTENSION_VERSION
    }
}

dependencies {

    // AndroidX
    implementation(Dependencies.Androidx.CORE_KTX)
    implementation(Dependencies.Androidx.LIFECYCLE)

    // Compose
    implementation(Dependencies.Compose.COMPOSE)
    implementation(platform(Dependencies.Compose.COMPOSE_BOM))
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_UI_GRAPHIC)
    implementation(Dependencies.Compose.PREVIEW)
    implementation(Dependencies.Compose.MATERIAL3)
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.31.5-beta")

    // Test
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
    androidTestImplementation(platform(Dependencies.Test.COMPOSE_BOM))
    androidTestImplementation(Dependencies.Test.UI_TEST)

    // Debug
    debugImplementation(Dependencies.Debug.COMPOSE_UI)
    debugImplementation(Dependencies.Debug.COMPOSE_UI_TEST)

    // Firebase
    implementation(platform(Dependencies.Firebase.FIREBASE_BOM))
    implementation(Dependencies.Firebase.FIREBASE_ANALYTICS)

    // Hilt
    implementation(Dependencies.Hilt.HILT_ANDROID)
    implementation(Dependencies.Hilt.HILT_NAVIGATION)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    implementation(project(":auth:ui"))
    implementation(project(":auth:data"))
    implementation(project(":auth:domain"))

    implementation("androidx.browser:browser:1.3.0")
}