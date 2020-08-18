import Config.Libs.Androidx
import Config.Libs.Firebase
import Config.Libs.Kotlin
import Config.Libs.Google
import Config.Libs.Network

apply(plugin = "com.google.gms.google-services")

dependencies {

    // Kotlin
    implementation(Kotlin.jdk8)

    // Coroutines
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutinesAndroid)
    implementation(Kotlin.coroutinesPlayServices)

    // AndroidX
    implementation(Androidx.appCompat)
    implementation(Androidx.lifecycleExtensions)
    implementation(Androidx.constraint)
    implementation(Androidx.material)

    implementation(Androidx.viewpager)
    implementation(Androidx.vectorAnimation)

    // Firebase
    implementation(Firebase.auth)
    implementation(Firebase.authKtx)
    implementation(Firebase.database)
    implementation(Firebase.databaseKtx)
    implementation(Firebase.storage)

    // Google
    implementation(Google.auth)

    // Network
    implementation(Network.retrofit2)
    implementation(Network.converterGson)
    implementation(Network.loggingInterceptor)

    // Modules
    implementation(project(":core"))
}
