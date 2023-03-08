plugins {
    alias(libs.plugins.javiersc.hubdle)
}

repositories {
    mavenCentral()
    maven(url = "https://www.jetbrains.com/intellij-repository/snapshots/")
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        jvm {
            features {
                jvmVersion(JavaVersion.VERSION_17)
                intellij {
                    plugin()
                }
            }
        }
    }
}
