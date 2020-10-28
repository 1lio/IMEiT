dependencies {

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.ktx)

    // Firebase repo impl
    implementation(Config.Libs.Firebase.databaseKtx)
    implementation(Config.Libs.Firebase.authKtx)
    implementation(Config.Libs.Firebase.storage)

    // Tests
    testImplementation(Config.Libs.Test.junit)
    androidTestImplementation(Config.Libs.Test.testRunner)
}
