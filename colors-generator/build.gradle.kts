plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        versioning {
            isEnabled.set(false)
        }
    }

    kotlin {
        jvm {
            main {
                dependencies {
                    implementation(gradleApi())
                    implementation(gradleKotlinDsl())
                }
            }
        }
    }
}
