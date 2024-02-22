plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    id("com.google.gms.google-services")
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = BuildConfig.COMPILE_SDK

    defaultConfig {
        minSdk = BuildConfig.MIN_SDK
        targetSdk = BuildConfig.TARGET_SDK
        testInstrumentationRunner = BuildConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(Dependencies.Androidx.CORE_KTX)
    implementation(Dependencies.Androidx.APPCOMPAT)
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")

    // hilt
    implementation(Dependencies.Hilt.HILT_ANDROID)
    implementation(Dependencies.Hilt.HILT_NAVIGATION)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER)

    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Coroutines
    implementation(Dependencies.Coroutines.KOTLIN_COROUTINE)
    implementation(Dependencies.Coroutines.KOTLIN_COROUTINE_ANDROID)

    // Firebase
    implementation(platform(Dependencies.Firebase.FIREBASE_BOM))
    implementation(Dependencies.Firebase.FIREBASE_ANALYTICS)
    implementation(Dependencies.Firebase.FIREBASE_AUTH)
    implementation(Dependencies.Firebase.FIREBASE_FIRE_STORE)
    implementation(Dependencies.Firebase.FIRE_STORE)

    // Compose
    implementation(Dependencies.Compose.COMPOSE)
    implementation(platform(Dependencies.Compose.COMPOSE_BOM))
    implementation(Dependencies.Compose.COMPOSE_UI)
    implementation(Dependencies.Compose.COMPOSE_UI_GRAPHIC)
    implementation(Dependencies.Compose.PREVIEW)
    implementation(Dependencies.Compose.MATERIAL3)

    implementation("androidx.browser:browser:1.3.0")
}