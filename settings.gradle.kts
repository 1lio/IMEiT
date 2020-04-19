rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "IMEiT"

include(":app")

include(":core")
project(":core").projectDir =  File(rootDir, "/base/core")

include(":network")
project(":network").projectDir =  File(rootDir, "/base/network")

include(":repo")
project(":repo").projectDir =  File(rootDir, "/base/repo")


include(":auth")
project(":auth").projectDir = File(rootDir, "/features/auth")