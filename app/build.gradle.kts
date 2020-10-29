android {
    defaultConfig {
        applicationId = Config.applicationID

        versionCode = Config.appVersionCode
        versionName = Config.appVersionName
    }
}

dependencies {

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.material)

    implementation(project(":auth"))
    api(project(":core"))
}