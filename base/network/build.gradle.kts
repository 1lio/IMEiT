android {

    defaultConfig {
        versionCode = 1
        versionName = "1.0"

        ///
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)

    testImplementation(Config.Libs.Test.junit)
    androidTestImplementation(Config.Libs.Test.testRunner)
    androidTestImplementation(Config.Libs.Test.espresso)
}
