object Config {

    // app
    const val appVersionName = "3.0.1"
    const val appVersionCode = 25
    const val buildTools = "30.0.2"
    const val applicationID = "ru.student.assistant"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val mainDir = "src/main/kotlin"
    const val testDir = "src/test/kotlin"
    const val androidTestDir = "src/androidTest/kotlin"

    private const val kotlinVersion = "1.4.10"

    object SdkVersions {
        const val compile = 30
        const val target = 30
        const val min = 23
    }

    object Plugins {
        const val gradleAndroid = "com.android.tools.build:gradle:4.1.0"
        const val gradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val googleServices = "com.google.gms:google-services:4.3.4"
    }

    object Libs {

        object Kotlin {
            private const val ver = "1.4.0"
            const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$ver"
            const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$ver"
            const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$ver"
        }

        object Androidx {
            const val appCompat = "androidx.appcompat:appcompat:1.2.0"
            const val ktx = "androidx.core:core-ktx:1.3.2"
            const val ktxCollection = "androidx.collection:collection-ktx:1.1.0"
            const val ktxFragment = "androidx.fragment:fragment-ktx:1.2.5"
            const val constraint = "androidx.constraintlayout:constraintlayout:2.0.2"
            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
            const val viewpager = "androidx.viewpager:viewpager:1.0.0"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val material = "com.google.android.material:material:1.2.1"
            const val vectorAnimation = "androidx.vectordrawable:vectordrawable-animated:1.1.0"
        }

        object Firebase {
            private const val bomVer = "26.0.0"

            const val bom = "com.google.firebase:firebase-bom:$bomVer"
            const val auth = "com.google.firebase:firebase-auth-ktx"
            const val database = "com.google.firebase:firebase-database-ktx"
            const val storage = "com.google.firebase:firebase-storage-ktx"
        }

        object Google {
            const val auth = "com.google.android.gms:play-services-auth:18.1.0"
            const val maps = "com.google.android.gms:play-services-maps:17.0.0"
        }

        object Network {
            private const val retrofitVer = "2.9.0"
            const val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofitVer"
            const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVer"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.8.1"
        }

        object Rx {
            const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
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

    object Proguard {
        const val file = "proguard-android-optimize.txt"
        const val rules = "proguard-rules.pro"
    }

    object BuildType {
        const val release = "release"
        const val debug = "debug"
    }
}