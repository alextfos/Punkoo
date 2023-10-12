plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
}

android {
    compileSdk = PunkooProject.ANDROID_SDK
    namespace = "com.alextfos.punkoo.common"

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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // App dependencies
    api(project(Modules.STYLES))

    // Android dependencies
    implementation(androidLibs.navigation)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.materialCompose)
    implementation(androidLibs.paging)
    implementation(androidLibs.activity)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.hiltAndroid)

    // Tooling Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    // Networking dependencies
    implementation(networkingLibs.okHttp)
    api(networkingLibs.retrofit)
    api(networkingLibs.moshi)

    // Third Party dependencies
    api(thirdPartyLibs.timber)
    implementation(thirdPartyLibs.coil)

    // Test dependencies
    testImplementation(testLibs.coroutinesTest)
    testImplementation(testLibs.mockk)
    testImplementation(testLibs.archCoreTesting)
    testImplementation(testLibs.junit)
    androidTestImplementation(testLibs.junitTest)
    androidTestImplementation(testLibs.espresso)
    testImplementation(testLibs.hamcrest)
}
