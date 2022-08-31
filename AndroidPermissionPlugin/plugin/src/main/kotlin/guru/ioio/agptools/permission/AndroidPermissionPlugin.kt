/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package guru.ioio.agptools.permission

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A simple 'hello world' plugin.
 */
class AndroidPermissionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("APPlugin.apply()")
        val extension = if (project.plugins.hasPlugin("com.android.application")) {
            project.extensions.findByType(AppExtension::class.java)
        } else if (project.plugins.hasPlugin("com.android.library")) {
            project.extensions.findByType(LibraryExtension::class.java)
        } else {
            null
        }
        extension?.registerTransform(APTransform(extension is LibraryExtension))

    }
}