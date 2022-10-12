plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        documentation {
            changelog()
            readme {
                badges {
                    coverage = false
                    mavenCentral = false
                    quality = false
                    snapshots = false
                    techDebt = false
                }
            }
            site()
        }
        nexus()
    }
}
