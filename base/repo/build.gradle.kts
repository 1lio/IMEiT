//apply(plugin = "com.google.gms.google-services")

dependencies {

    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)

    // Firebase repo impl
    implementation(platform(Config.Libs.Firebase.bom))

    implementation(Config.Libs.Firebase.database)
    implementation(Config.Libs.Firebase.auth)
    implementation(Config.Libs.Firebase.storage)

    //Rx
    implementation(Config.Libs.Rx.rxJava)
    implementation(Config.Libs.Rx.rxAndroid)

    // Tests
    testImplementation(Config.Libs.Test.junit)
    androidTestImplementation(Config.Libs.Test.testRunner)

    // Библиотека для хранения примитивных типов
    implementation(Config.Libs.Misc.hawk)

    api(project(":core"))
}
