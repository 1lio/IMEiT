object Config {

    // app
    const val appVersion = "FINAL"
    const val appVersionCode = 24
    const val buildTools = "29.0.3"
    const val applicationID = "ru.suhov.student"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val kotlinDir = "src/main/kotlin"

    private const val kotlinVersion = "1.3.72"

    object SdkVersions {
        const val compile = 29
        const val target = 29
        const val min = 23
    }

    object Plugins {
        const val gradleAndroid = "com.android.tools.build:gradle:4.0.0"
        const val gradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val googleServices = "com.google.gms:google-services:4.3.3"
    }

    object Libs {

        object Kotlin {
            //  private const val ver = "1.3.6"

            const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
            //  const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$ver"
            //  const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$ver"
        }

        object Androidx {
            const val appCompat = "androidx.appcompat:appcompat:1.1.0"
            const val ktx = "androidx.core:core-ktx:1.2.0"
            const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
            const val viewpager = "androidx.viewpager:viewpager:1.0.0"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val material = "com.google.android.material:material:1.1.0"
        }

        object Firebase {
            const val auth = "com.google.firebase:firebase-auth:19.3.0"
            const val database = "com.google.firebase:firebase-database:19.2.1"
        }

        object Rx {
            const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
        }

        object PlayServices {
            const val playMaps = "com.google.android.gms:play-services-maps:17.0.0"
        }

        object Misc {
            const val hawk = "com.orhanobut:hawk:2.0.1"
        }

        object Test {
            const val junit = "junit:junit:4.13"
            const val testRunner = "androidx.test:runner:1.2.0"
            const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object Features {
        object Auth {
            const val versionName = "auth"
            const val versionCode = 1
        }
    }
}