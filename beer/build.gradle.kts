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
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
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
    implementation(Compose.pagingCompose)
    implementation(Coroutines.core)
    implementation(Coroutines.android)
    implementation(Api.arrowCore)
    implementation(androidLibs.lifecycleViewModel)
    implementation(androidLibs.lifecycleRuntime)
    implementation(Hilt.android)

    // Compose Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    testImplementation(Test.coroutinesTest)
    testImplementation(Test.testCore)
    testImplementation(Test.archCore)
    testImplementation(Test.junit)
    testImplementation(Test.mockk)

    androidTestImplementation(Test.junitTest)
    androidTestImplementation(ComposeTest.uiTestJunit4)

    kapt(Hilt.compiler)
}