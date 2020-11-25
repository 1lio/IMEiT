android {
    defaultConfig {
        applicationId = Config.applicationID

        versionCode = Config.appVersionCode
        versionName = Config.appVersionName
    }

    // ProductFlavors - ползеная фича чтобы создать несколько версий приложения
    // В данном случае 2 версии, для студентов и преподователей

    flavorDimensions("googlePlay")
    productFlavors {
        create("teacher") {
            dimension = "googlePlay"
            applicationId += Config.Flavors.appTeacherID
            versionNameSuffix = Config.Flavors.versionTeacherCode
        }

        create("student") {
            dimension = "googlePlay"
            applicationId += Config.Flavors.appStudentID
            versionNameSuffix = Config.Flavors.versionStudentCode
        }
    }

}

dependencies {

    // Libs
    implementation(Config.Libs.Androidx.appCompat)
    implementation(Config.Libs.Androidx.core)
    implementation(Config.Libs.Androidx.material)

    // Base
    api(project(":core"))

    // Modules
    implementation(project(":auth"))
}