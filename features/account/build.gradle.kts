import Config.Libs.Androidx
import Config.Libs.Kotlin

dependencies {

    // Kotlin
    implementation(Kotlin.jdk8)

    // AndroidX
    implementation(Androidx.appCompat)
    implementation(Androidx.constraint)
    implementation(Androidx.material)

    // Modules
    api(project(":core"))
}
