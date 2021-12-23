import com.example.notes.buildsrc.Libs
import com.example.notes.buildsrc.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")

}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.notes"
        minSdk = 22
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {

        create("stage_auth") {
            storeFile = rootProject.file("keystore.jks")
            storePassword = "android"
            keyAlias = "key0"
            keyPassword = "android"
        }
    }

    buildTypes {

        create("stage") {
            isDebuggable = true
            applicationIdSuffix = ".stage"
            signingConfig = signingConfigs.getByName("stage_auth")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions("type")

    productFlavors {

        create("free") {
            applicationIdSuffix = ".free"
            dimension = "type"
        }
        create("paid") {
            applicationIdSuffix = ".paid"
            dimension = "type"
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
        kotlinCompilerVersion = "1.5.21"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {

    implementation(Libs.Room.runTime)
    annotationProcessor(Libs.Room.compiler)
    kapt(Libs.Room.room_compiler)
    implementation(Libs.Room.room_ktx)

    implementation(Libs.core_ktx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.lifecycle_runtime)

    implementation(Libs.ConstraintLayout.constraintLayoutCompose)
    implementation(Libs.Lifecycle.viewModelCompose)
    implementation(Libs.Navigation.navigationCompose)
    implementation(Libs.Coil.coilCompose)

    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.composeMaterial)
    implementation(Libs.Compose.preview)
    implementation(Libs.Compose.material)
    implementation(Libs.Compose.activityCompose)
    implementation(Libs.Compose.animation)

    implementation(Libs.Coroutines.android)
    implementation(Libs.Coroutines.core)

    testImplementation(Libs.Test.jUnit)
    androidTestImplementation(Libs.Test.ext_jUnit)
    androidTestImplementation(Libs.Test.espresso_core)
    androidTestImplementation(Libs.Test.ui_test_junit4)
    debugImplementation(Libs.Test.ui_tooling)

    //Dagger - Hilt
    implementation(Libs.Dagger.daggerHilt)
    kapt(Libs.Dagger.hiltAndroidCompiler)
//    implementation(Libs.Dagger.hiltLifeCycle)
    kapt(Libs.Dagger.hiltCompiler)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}