plugins {
    `javiersc-versioning`
    `javiersc-all-projects`
    `javiersc-changelog`
    `javiersc-code-analysis`
    `javiersc-code-formatter`
    `javiersc-docs`
    `javiersc-nexus`
    `javiersc-readme-badges-generator`
}

docs {
    navigation {
        reports {
            allTests.set(false)
            codeAnalysis.set(false)
            codeCoverage.set(false)
            codeQuality.set(false)
        }
    }
}

readmeBadges {
    coverage.set(false)
    mavenCentral.set(false)
    quality.set(false)
    snapshots.set(false)
    techDebt.set(false)
}
