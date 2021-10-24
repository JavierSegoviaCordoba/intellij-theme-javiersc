import org.jetbrains.changelog.ChangelogPluginExtension

plugins {
    `javiersc-kotlin-jvm`
    alias(pluginLibs.plugins.jetbrains.intellij)
}

repositories {
    mavenCentral()
}

intellij {
    pluginName.set(property("pom.name").toString())
    version.set(property("platformVersion").toString())
    type.set(property("platformType").toString())
    downloadSources.set(property("platformDownloadSources").toString().toBoolean())
    updateSinceUntilBuild.set(true)
}

val pluginSinceBuild: String by project
val pluginUntilBuild: String by project

tasks {
    patchPluginXml {
        val changelog: ChangelogPluginExtension = rootProject.extensions.getByType()
        version.set("${project.version}")
        sinceBuild.set(pluginSinceBuild)
        untilBuild.set(pluginUntilBuild)

        changeNotes.set(provider {
            changelog.run {
                getOrNull("${project.version}") ?: getLatest()
            }.toHTML()
        })
    }
}
