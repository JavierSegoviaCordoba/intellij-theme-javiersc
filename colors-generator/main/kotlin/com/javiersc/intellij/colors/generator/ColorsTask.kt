package com.javiersc.intellij.colors.generator

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.listProperty
import org.gradle.kotlin.dsl.property

class ColorsTask(project: Project) : DefaultTask() {

    val themeName: Property<String> = project.objects.property()
    val isDark: Property<Boolean> = project.objects.property()
    val author: Property<String> = project.objects.property()
    val editorScheme: Property<String> = project.objects.property()

    @Input val colors: ListProperty<Color> = project.objects.listProperty<Color>()

    @OutputFile val file: RegularFileProperty = project.objects.fileProperty()

    @TaskAction fun run() {
        when {
            isJson -> TODO()
            isXml -> TODO()
        }
    }

    private val isJson: Boolean get() = file.get().asFile.extension == "json"
    private val isXml: Boolean get() = file.get().asFile.extension == "xml"
}
