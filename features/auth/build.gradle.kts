import Config.Libs.Androidx

dependencies {

    implementation(Androidx.appCompat)
    implementation(Androidx.constraint)
    implementation(Androidx.material)
    implementation(Androidx.vectorAnimation)
    implementation(Androidx.lifecycleExtensions)

    api(project(":core"))
//    api(project(":repo"))
}
