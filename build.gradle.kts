plugins {
    alias(libs.plugins.javiersc.hubdle)
}

hubdle {
    config {
        documentation {
            changelog()
            readme {
                badges {
                    coverage.set(false)
                    mavenCentral.set(false)
                    quality.set(false)
                    snapshots.set(false)
                    techDebt.set(false)
                }
            }
            site()
        }
        nexus()
    }
}
