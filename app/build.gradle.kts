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
    implementation(Config.Libs.Androidx.material)

    // modules
    implementation(project(":auth"))
}
