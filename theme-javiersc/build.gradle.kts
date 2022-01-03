import org.jetbrains.changelog.ChangelogPluginExtension

plugins {
    `kotlin-jvm`
    `javiersc-kotlin-config`
    alias(pluginLibs.plugins.jetbrains.intellij)
}

repositories { mavenCentral() }

intellij {
    pluginName.set(property("pom.name").toString())
    version.set(property("platformVersion").toString())
    type.set(property("platformType").toString())
    downloadSources.set(property("platformDownloadSources").toString().toBoolean())
    updateSinceUntilBuild.set(true)
}

val pluginSinceBuild: String by project
val pluginUntilBuild: String by project

val jetbrainsMarketplaceCertificateChain: String =
    System.getenv("JETBRAINS_MARKETPLACE_CERTIFICATE_CHAIN")
        ?: properties["jetbrains.marketplace.certificateChain"].toString()

val jetbrainsMarketplaceKey: String =
    System.getenv("JETBRAINS_MARKETPLACE_KEY")
        ?: properties["jetbrains.marketplace.key"].toString()

val jetbrainsMarketplaceKeyPassphrase: String =
    System.getenv("JETBRAINS_MARKETPLACE_KEY_PASSPHRASE")
        ?: properties["jetbrains.marketplace.keyPassphrase"].toString()

val jetbrainsMarketplaceToken: String =
    System.getenv("JETBRAINS_MARKETPLACE_TOKEN")
        ?: properties["jetbrains.marketplace.token"].toString()

tasks {
    patchPluginXml {
        val changelog: ChangelogPluginExtension = rootProject.extensions.getByType()
        version.set("${project.version}")
        sinceBuild.set(pluginSinceBuild)
        untilBuild.set(pluginUntilBuild)

        changeNotes.set(
            provider { changelog.run { getOrNull("${project.version}") ?: getLatest() }.toHTML() }
        )
    }

    publishPlugin {
        token.set(jetbrainsMarketplaceToken)
    }

    signPlugin {
        certificateChain.set(jetbrainsMarketplaceCertificateChain)
        privateKey.set(jetbrainsMarketplaceKey)
        password.set(jetbrainsMarketplaceKeyPassphrase)
    }
}
