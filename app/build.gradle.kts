apply(plugin = "com.google.gms.google-services")

android {
    defaultConfig {
        applicationId = Config.applicationID
        versionCode = Config.appVersionCode
        versionName = Config.appVersionName
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
    implementation("android.arch.navigation:navigation-fragment:2.2.1")
    implementation("android.arch.navigation:navigation-ui:2.2.1")

    //Rx
    implementation(Config.Libs.Rx.rxJava)
    implementation(Config.Libs.Rx.rxAndroid)

    // PlayServices
    implementation(Config.Libs.Google.maps)

    // Библиотека для хранения примитивных типов
    implementation(Config.Libs.Misc.hawk)

    //Firebase
    implementation(Config.Libs.Firebase.database)

    implementation(project(":auth"))
}
