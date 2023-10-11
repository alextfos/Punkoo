plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = PunkooProject.ANDROID_SDK
    namespace = "com.alextfos.beer"
    defaultConfig {
        minSdk = PunkooProject.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    // App dependencies
    api(project(Modules.COMMON))
    implementation(project(Modules.STYLES))

    // Android dependencies
    implementation(androidLibs.activity)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.materialCompose)
    implementation(androidLibs.navigation)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.hiltNavigation)
    implementation(androidLibs.paging)
    implementation(androidLibs.lifecycleViewModel)
    implementation(androidLibs.lifecycleRuntime)
    implementation(androidLibs.hiltAndroid)
    kapt(androidLibs.hiltCompiler)

    // Tooling Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    // Third Party dependencies
    implementation(thirdPartyLibs.coil)

    // Test dependencies
    testImplementation(testLibs.coroutinesTest)
    testImplementation(testLibs.testCore)
    testImplementation(testLibs.archCoreTesting)
    testImplementation(testLibs.junit)
    testImplementation(testLibs.mockk)
    androidTestImplementation(testLibs.junitTest)
    androidTestImplementation(androidLibs.uiTestJunit4)

}