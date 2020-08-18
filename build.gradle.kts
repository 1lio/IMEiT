buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath(Config.Plugins.gradleAndroid)
        classpath(Config.Plugins.gradleKotlin)
        classpath(Config.Plugins.googleServices)
    }
}

allprojects {

    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    if ((group as String).isNotEmpty()) configureAndroid()
}

fun Project.configureAndroid() {

    val type = if (name == "app") "application" else "library"

    // Base plugins
    apply(plugin = "com.android.$type")
    apply(plugin = "org.jetbrains.kotlin.android")
    apply(plugin = "org.jetbrains.kotlin.android.extensions")

    configure<com.android.build.gradle.BaseExtension> {

        compileSdkVersion(Config.SdkVersions.compile)
        buildToolsVersion = Config.buildTools

        defaultConfig {

            minSdkVersion(Config.SdkVersions.min)
            targetSdkVersion(Config.SdkVersions.target)

            vectorDrawables.useSupportLibrary = true

            testInstrumentationRunner = Config.testRunner

            consumerProguardFiles("consumer-rules.pro")
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        sourceSets {
            getByName("androidTest").java.srcDirs(Config.androidTestDir)
            getByName("main").java.srcDirs(Config.mainDir)
            getByName("test").java.srcDirs(Config.testDir)
        }
    }

}