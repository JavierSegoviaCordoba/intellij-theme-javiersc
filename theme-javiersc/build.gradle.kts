plugins {
    alias(libs.plugins.javiersc.hubdle)
}

repositories {
    mavenCentral()
}

hubdle {
    config {
        explicitApi()
        publishing()
    }
    kotlin {
        intellijPlugin()
    }
}
