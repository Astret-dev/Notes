
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.example.notes.buildsrc.Libs.buildTools)
        classpath(com.example.notes.buildsrc.Libs.plugin)
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}