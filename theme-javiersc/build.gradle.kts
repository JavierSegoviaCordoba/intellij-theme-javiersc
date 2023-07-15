repositories {
    mavenCentral()
    maven(url = "https://www.jetbrains.com/intellij-repository/snapshots/")
}

hubdle {
    config { //
        publishing { //
            signing { //
                isEnabled.set(false)
            }
        }
    }
    java {
        features {
            jvmVersion(JavaVersion.VERSION_17)
            intellij { //
                plugin()
            }
        }
    }
}
