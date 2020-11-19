dependencies {

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.material)

    implementation(project(":auth"))
    api(project(":core"))
}