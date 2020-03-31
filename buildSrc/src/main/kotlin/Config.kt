object Config {

    private const val kotlinVersion = "1.3.71"

    const val version = "FINAL"
    const val versionCode = 24
    const val buildTools = "29.0.3"

    const val applicationID = " ru.suhov.student"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val kotlinDir = "src/main/kotlin"

    object SdkVersions {
        const val compile = 29
        const val target = 29
        const val min = 23
    }

    object Plugins {
        const val gradleAndroid = "com.android.tools.build:gradle:3.5.3"
        const val gradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val googleServices = "com.google.gms:google-services:4.3.1"
        const val realm = "io.realm:realm-gradle-plugin:5.3.0"
    }

    object Libs {

        object Kotlin {
            private const val coroutines = "1.3.2"
            const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
            const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
            const val coroutinesAndroid =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
        }

        object Androidx {
            const val appCompat = "androidx.appcompat:appcompat:1.1.0"
            const val ktx = "androidx.core:core-ktx:1.1.0"

            const val annotations = "androidx.annotation:annotation:1.1.0"
            const val cardView = "androidx.cardview:cardview:1.0.0"
            const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"

            const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:2.1.0"
            const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
            const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:2.1.0"
            const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:2.2.0"

            const val paging = "androidx.paging:paging-runtime:2.1.0"
            const val viewpager = "androidx.viewpager:viewpager:1.0.0"
            const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0-rc01"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val material = "com.google.android.material:material:1.1.0"
        }

        object Firebase {
            const val auth = "com.google.firebase:firebase-auth:19.3.0"
            const val core = "com.google.firebase:firebase-core:17.2.0"
            const val database = "com.google.firebase:firebase-database:19.2.1"
            const val firestore = "com.google.firebase:firebase-firestore:21.1.1"
            const val storage = "com.google.firebase:firebase-storage:19.0.1"
        }


        object Rx {
            const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
            const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
        }

        object PlayServices {
            const val playMaps = "com.google.android.gms:play-services-maps:17.0.0"
            const val playAuth = "com.google.android.gms:play-services-auth:17.0.0"
        }

        object Misc {

            private const val retrofitVersion = "2.4.0"
            private const val leakCanaryVersion = "1.6.1"
            private const val glideVersion = "4.8.0"
            private const val butterVersion = "10.1.0"

            const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
            const val retrofitGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"

            const val leakCanary = "com.squareup.leakcanary:leakcanary-android:$leakCanaryVersion"
            const val leakCanaryFragments =
                "com.squareup.leakcanary:leakcanary-support-fragment:$leakCanaryVersion"
            const val leakCanaryNoop =
                "com.squareup.leakcanary:leakcanary-android-no-op:$leakCanaryVersion"

            const val glide = "com.github.bumptech.glide:glide:$glideVersion"
            const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"

            const val permissions = "pub.devrel:easypermissions:3.0.0"
        }

        object Other {
            const val hawk = "com.orhanobut:hawk:2.0.1"
        }


        object Test {
            const val junit = "junit:junit:4.12"
            const val junitExt = "androidx.test.ext:junit:1.1.1"
            const val espresso = "androidx.test.espresso:espresso-core:3.2.0"

            const val mockito = "org.mockito:mockito-android:2.21.0"
            const val robolectric = "org.robolectric:robolectric:4.0.2"

            const val core = "androidx.test:core:1.2.0"
            const val archCoreTesting = "androidx.arch.core:core-testing:2.0.0"
            const val runner = "androidx.test:runner:1.2.0"
            const val rules = "androidx.test:rules:1.2.0"
        }

        object Lint {
            private const val version = "26.5.0"
            const val api = "com.android.tools.lint:lint-api:$version"
            const val tests = "com.android.tools.lint:lint-tests:$version"
        }
    }
}