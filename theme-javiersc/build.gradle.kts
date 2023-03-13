repositories {
    mavenCentral()
    maven(url = "https://www.jetbrains.com/intellij-repository/snapshots/")
}

hubdle {
    config {
        analysis()
        explicitApi()
        publishing()
    }
    kotlin {
        jvm {
            features {
                jvmVersion(JavaVersion.VERSION_17)
                intellij { plugin() }
            }
        }
    }
}
