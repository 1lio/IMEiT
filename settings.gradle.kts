rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "IMEiT"

include(":app")

include(":core")
project(":core").projectDir =  File(rootDir, "/base/core")
