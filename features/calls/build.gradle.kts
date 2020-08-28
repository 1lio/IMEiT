import Config.Libs.Androidx
import Config.Libs.Kotlin

dependencies {



    // AndroidX
    implementation(Androidx.appCompat)
    implementation(Androidx.constraint)
    implementation(Androidx.material)

    //JetPack
    implementation(Androidx.lifecycleExtensions)
    implementation(Androidx.recyclerView)
    implementation(Androidx.viewpager)

    //Rx
    implementation(Config.Libs.Rx.rxJava)
    implementation(Config.Libs.Rx.rxAndroid)

    // PlayServices
    implementation(Config.Libs.Google.maps)

    // Библиотека для хранения примитивных типов
    implementation(Config.Libs.Misc.hawk)

    //Firebase
    implementation(Config.Libs.Firebase.database)
    // Modules
    api(project(":core"))
}
