plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
}

android {
    compileSdk = PunkooProject.compileSdk
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
    implementation(Compose.tooling)
    implementation(Compose.pagingCompose)
    implementation(androidLibs.activity)
    implementation(androidLibs.runtimeLiveData)
    implementation(Hilt.android)

    api(Log.timber)

    // API
    implementation(Api.arrowCore)
    api(Api.retrofit)
    implementation(Api.okHttp)
    api(Api.moshi)

    // Compose
    debugImplementation(Compose.toolingPreview)
    debugImplementation(Compose.poolingContainer)
    implementation(thirdPartyLibs.coil)

    // Test
    testImplementation(Test.coroutinesTest)
    testImplementation(Test.mockk)
    testImplementation(Test.archCore)
    testImplementation(Test.junit)
    androidTestImplementation(Test.junitTest)
    androidTestImplementation(Test.espressoCore)
}
