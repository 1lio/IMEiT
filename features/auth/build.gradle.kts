plugins {
    kotlin("android")
    kotlin("android.extensions")
  //  id("com.google.gms.google-services")
}

android {

    defaultConfig {
        versionName = Config.Features.Auth.versionName
        versionCode = Config.Features.Auth.versionCode
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(Config.Libs.Kotlin.jdk8)
    implementation(Config.Libs.Androidx.appCompat)

    implementation(Config.Libs.Androidx.ktx)

    //JetPack
    implementation(Config.Libs.Androidx.lifecycleExtensions)
    implementation(Config.Libs.Androidx.constraint)
    implementation(Config.Libs.Androidx.material)
    implementation(Config.Libs.Androidx.recyclerView)
    implementation(Config.Libs.Androidx.viewpager)

    //Rx
    implementation(Config.Libs.Rx.rxJava)
    implementation(Config.Libs.Rx.rxAndroid)

    // PlayServices
   // implementation(Config.Libs.PlayServices.playMaps)

    // Библиотека для хранения примитивных типов
    implementation(Config.Libs.Misc.hawk)

    implementation(project(":core"))

    //Firebase
  //  implementation(Config.Libs.Firebase.auth)
  //  implementation(Config.Libs.Firebase.database)
}
