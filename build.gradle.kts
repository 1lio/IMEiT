import Config.kotlinDir

buildscript {

    repositories {
        google()
        jcenter()
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

    // Configure all gradle modules as android/library
    if ((group as String).isNotEmpty()) configureAndroid()
}

tasks.withType<Wrapper>().configureEach {
    distributionType = Wrapper.DistributionType.ALL
}

fun Project.configureAndroid() {

    if (name == "app") apply(plugin = "com.android.application") else apply(plugin = "com.android.library")

    configure<com.android.build.gradle.BaseExtension> {

        compileSdkVersion(Config.SdkVersions.compile)
        buildToolsVersion = Config.buildTools

        defaultConfig {

            minSdkVersion(Config.SdkVersions.min)
            targetSdkVersion(Config.SdkVersions.target)

            vectorDrawables.useSupportLibrary = true

            testInstrumentationRunner = Config.testRunner
        }

        sourceSets {
            getByName("main").java.srcDirs(kotlinDir)
            getByName("test").java.srcDirs(kotlinDir)
        }
    }

}