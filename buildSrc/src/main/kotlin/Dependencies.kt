object Dependencies {

    object Androidx {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.LIFECYCLE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APPCOMPAT}"
    }

    object Compose {
        const val COMPOSE = "androidx.activity:activity-compose:${Versions.Compose.COMPOSE}"
        const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.Compose.COMPOSE_BOM}"
        const val COMPOSE_UI = "androidx.compose.ui:ui"
        const val COMPOSE_UI_GRAPHIC = "androidx.compose.ui:ui-graphics"
        const val PREVIEW = "androidx.compose.ui:ui-tooling-preview"
        const val MATERIAL3 = "androidx.compose.material3:material3"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Versions.Test.ANDROIDX_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.Compose.COMPOSE_BOM}"
        const val UI_TEST = "androidx.compose.ui:ui-test-junit4"
    }

    object Debug {
        const val COMPOSE_UI = "androidx.compose.ui:ui-tooling"
        const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-manifest"
    }

    object Firebase {
        const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.Firebase.FIREBASE_BOM}"
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics"
        const val FIREBASE_AUTH = "com.google.firebase:firebase-auth-ktx"
        const val FIREBASE_FIRE_STORE = "com.google.firebase:firebase-firestore-ktx"
        const val FIRE_STORE = "com.google.firebase:firebase-firestore"
    }

    object Hilt {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.Hilt.HILT}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT}"
        const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation:${Versions.Hilt.HILT_NAVIGATION}"
    }

    object Coroutines {
        const val KOTLIN_COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.KOTLIN_COROUTINE}"
        const val KOTLIN_COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.KOTLIN_COROUTINE_ANDROID}"
    }
}