import Config.Libs.Androidx

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

    // Modules
    api(project(":core"))
    api(project(":repo"))
}
