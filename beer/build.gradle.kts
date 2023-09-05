plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = PunkooProject.androidSdk
    namespace = "com.alextfos.beer"
    defaultConfig {
        minSdk = PunkooProject.minSdk

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
        kotlinCompilerExtensionVersion = PunkooProject.composeCompilerVersion
    }
}

dependencies {

    api(project(Modules.common))
    implementation(project(Modules.styles))

    implementation(androidLibs.activity)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.materialCompose)
    implementation(androidLibs.navigation)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.hiltNavigation)
    implementation(thirdPartyLibs.coil)
    implementation(androidLibs.paging)
    implementation(thirdPartyLibs.arrowCore)
    implementation(androidLibs.lifecycleViewModel)
    implementation(androidLibs.lifecycleRuntime)
    implementation(androidLibs.hiltAndroid)
    kapt(androidLibs.hiltCompiler)

    // Compose Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    testImplementation(testLibs.coroutinesTest)
    testImplementation(testLibs.testCore)
    testImplementation(testLibs.archCoreTesting)
    testImplementation(testLibs.junit)
    testImplementation(testLibs.mockk)

    androidTestImplementation(testLibs.junitTest)
    androidTestImplementation(androidLibs.uiTestJunit4)

}