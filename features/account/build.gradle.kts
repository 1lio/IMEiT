import Config.Libs.Androidx

dependencies {

    // AndroidX
    implementation(Androidx.appCompat)
    implementation(Androidx.constraint)
    implementation(Androidx.material)

    // Modules
    api(project(":core"))
    api(project(":repo"))
}
