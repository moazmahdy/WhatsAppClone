import org.gradle.api.JavaVersion

object BuildConfig {

    const val APP_ID = "com.example.wahtsappclone"

    const val COMPILE_SDK = 34
    const val TARGET_SDK = 34
    const val MIN_SDK = 24

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    val JAVA_VERSION_NAME = JavaVersion.VERSION_11

    const val KOTLIN_COMPILER_EXTENSION_VERSION = "1.4.1"
}