import Config.Libs.Androidx
import Config.Libs.Firebase
import Config.Libs.Kotlin

apply(plugin = "com.google.gms.google-services")

dependencies {

    // Coroutines
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutinesAndroid)
    implementation(Kotlin.coroutinesPS)

    // AndroidX
    implementation(Androidx.appCompat)
    implementation(Androidx.lifecycleExtensions)
    implementation(Androidx.constraint)
    implementation(Androidx.material)

    implementation(Androidx.viewpager)
    implementation(Androidx.vectorAnimation)

    // Firebase
    implementation(Firebase.authKtx)
    implementation(Firebase.database)
    implementation(Firebase.databaseKtx)
    implementation(Firebase.storage)

    api(project(":core"))
}
