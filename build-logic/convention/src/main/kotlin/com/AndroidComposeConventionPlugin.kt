package com

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.foodgo.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            when {
                pluginManager.hasPlugin("com.android.application") -> {
                    configureAndroidCompose(
                        extensions.getByType<ApplicationExtension>()
                    )
                }

                pluginManager.hasPlugin("com.android.library") -> {
                    configureAndroidCompose(
                        extensions.getByType<LibraryExtension>()
                    )
                }

                else -> error(
                    "Unsupported project type."
                )
            }
        }
    }
}