plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = PunkooProject.compileSdk
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Build.composeCompilerVersion
    }
}

dependencies {

    api(project(Modules.common))
    implementation(project(Modules.styles))

    implementation(androidLibs.activity)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.material)
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