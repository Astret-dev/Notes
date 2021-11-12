package com.example.notes.buildsrc

import com.example.notes.buildsrc.Versions.roomVersion

object Versions {
    const val kotlin = "1.6.0"
    const val compose = "1.0.1"
    const val core_ktx = "1.6.0"
    const val appCompat = "1.3.1"
    const val material = "1.4.0"
    const val composeMaterial = "1.3.1"
    const val lifecycle_runtime = "1.4.0"
    const val jUnit = "4.+"
    const val ext_jUnit = "1.1.3"
    const val espresso_core = "3.4.0"
    const val build_tools = "7.0.2"
    const val plugin = "1.5.21"
    const val roomVersion = "2.3.0"
}

object DefaultConfigurations {

}

object Libs {

    const val buildTools = "com.android.tools.build:gradle:${Versions.build_tools}"
    const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.plugin}"

    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime}"

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
        const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val activityCompose = "androidx.activity:activity-compose:1.3.1"
        const val material = "com.google.android.material:material:${Versions.composeMaterial}"
        const val animation = "androidx.compose.animation:animation:${Versions.compose}"
    }

    object Test {
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val ext_jUnit = "androidx.test.ext:junit:${Versions.ext_jUnit}"
        const val espresso_core = "androidx.test.ext:junit:${Versions.espresso_core}"
        const val ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    }

    object Coroutines {
        private const val version = "1.5.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object ConstraintLayout {
        const val constraintLayoutCompose =
            "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02"
    }

    object Lifecycle {
        const val viewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    }

    object Navigation {
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-alpha06"
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:1.3.0"
    }

    object Room {
        const val runTime = "androidx.room:room-runtime:$roomVersion"
        const val compiler = "androidx.room:room-compiler:$roomVersion"
        const val room_compiler = "androidx.room:room-compiler:$roomVersion"
        const val room_ktx = "androidx.room:room-ktx:$roomVersion"
    }


}

