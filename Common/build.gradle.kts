plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
}

android {
    compileSdk = PunkooProject.androidSdk
    namespace = "com.alextfos.punkoo.common"

    defaultConfig {
        minSdk = PunkooProject.minSdk

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
        kotlinCompilerExtensionVersion = PunkooProject.composeCompilerVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Project
    api(project(Modules.styles))

    implementation(androidLibs.navigation)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.material)
    implementation(androidLibs.paging)
    implementation(androidLibs.activity)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.hiltAndroid)

    api(thirdPartyLibs.timber)

    // API
    implementation(thirdPartyLibs.arrowCore)
    api(networkingLibs.retrofit)
    implementation(networkingLibs.okHttp)
    api(networkingLibs.moshi)

    // Compose Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    // Third Party
    implementation(thirdPartyLibs.coil)

    // Test
    testImplementation(testLibs.coroutinesTest)
    testImplementation(testLibs.mockk)
    testImplementation(testLibs.archCoreTesting)
    testImplementation(testLibs.junit)
    androidTestImplementation(testLibs.junitTest)
    androidTestImplementation(testLibs.espresso)
}
