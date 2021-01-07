object Config {

    // app
    const val appVersionName = "3.0.1"
    const val appVersionCode = 25
    const val buildTools = "30.0.2"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val mainDir = "src/main/kotlin"
    const val testDir = "src/test/kotlin"
    const val androidTestDir = "src/androidTest/kotlin"

    private const val kotlinVersion = "1.4.21"

    // flavors
    const val applicationID = "ru.assistant"

    object Flavors {
        const val appTeacherID = ".teacher"
        const val versionTeacherCode = "-teacher"

        const val appStudentID = ".student"
        const val versionStudentCode = "-student"
    }


    object SdkVersions {
        const val compile = 30
        const val target = 30
        const val min = 23
    }

    object Plugins {
        const val gradleAndroid = "com.android.tools.build:gradle:4.1.1"
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
            private const val livedataVer = "2.2.0"

            const val appCompat = "androidx.appcompat:appcompat:1.2.0"
            const val core = "androidx.core:core-ktx:1.3.2"
            const val ktxCollection = "androidx.collection:collection-ktx:1.1.0"
            const val ktxFragment = "androidx.fragment:fragment-ktx:1.2.5"
            const val constraint = "androidx.constraintlayout:constraintlayout:2.0.4"

            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$livedataVer"
            const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:$livedataVer"
            const val livedata = "androidx.lifecycle:lifecycle-viewmodel-ktx:$livedataVer"

            const val viewpager = "androidx.viewpager:viewpager:1.0.0"
            const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
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
            const val okhttp =  "com.squareup.okhttp3:okhttp:4.5.0"
            const val websocket =  "org.java-websocket:Java-WebSocket:1.5.1"
        }

        object Rx {
            const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
        }

        object Misc {
            const val hawk = "com.orhanobut:hawk:2.0.1"
        }

        object Test {
            const val testRunner = "androidx.test:runner:1.3.0"
            const val testRules = "androidx.test:rules:1.3.0"
            const val testMonitor = "androidx.test:rules:1.3.0"
            const val testJunitKtx = "androidx.test.ext:junit-ktx:1.1.2"
            const val testCoreKtx = "androidx.test:core-ktx:1.3.0"

            const val junit = "junit:junit:4.13.1"

            const val junitExt = "androidx.test.ext:junit:1.1.2"
            const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
            const val espressoIntents = "androidx.test.espresso:espresso-intents:3.3.0"
            const val mockk = "io.mockk:mockk:1.10.2"
            const val robolectric = "org.robolectric:robolectric:4.4"
        //    const val supportRunner = "com.android.support.test:runner:1.0.2"
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