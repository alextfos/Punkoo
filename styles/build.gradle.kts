plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = PunkooProject.ANDROID_SDK
    namespace = "com.alextfos.punkoo.styles"
    defaultConfig {
        minSdk = PunkooProject.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = PunkooProject.javaVersion
        targetCompatibility = PunkooProject.javaVersion
    }
    kotlinOptions {
        jvmTarget = PunkooProject.javaVersion.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = PunkooProject.COMPOSE_COMPILER_VERSION
    }
}

dependencies {
    implementation(androidLibs.materialCompose)
}