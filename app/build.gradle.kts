plugins {
    kotlin("android")
    kotlin("android.extensions")
    id("com.google.gms.google-services")
}

android {

    defaultConfig {
        applicationId = Config.applicationID

        versionName = Config.appVersion
        versionCode = Config.appVersionCode
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

    //JetPack
    implementation(Config.Libs.Androidx.lifecycleExtensions)
    implementation(Config.Libs.Androidx.constraint)
    implementation(Config.Libs.Androidx.recyclerView)
    implementation(Config.Libs.Androidx.viewpager)

    //Navigation
    implementation("android.arch.navigation:navigation-fragment:2.2.2")
    implementation("android.arch.navigation:navigation-ui:2.2.2")

    //Rx
    implementation(Config.Libs.Rx.rxJava)
    implementation(Config.Libs.Rx.rxAndroid)

    // PlayServices
    implementation(Config.Libs.Google.maps)

    // Библиотека для хранения примитивных типов
    implementation(Config.Libs.Misc.hawk)

    //Firebase
    //implementation(Config.Libs.Firebase.auth)
    implementation(Config.Libs.Firebase.database)

    implementation(project(":auth"))
}
