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
