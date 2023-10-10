plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = PunkooProject.ANDROID_SDK
    namespace = PunkooProject.APPLICATION_ID

    defaultConfig {
        applicationId = PunkooProject.APPLICATION_ID
        minSdk = PunkooProject.MIN_SDK
        targetSdk = PunkooProject.ANDROID_SDK
        versionCode = PunkooProject.versionCode
        versionName = PunkooProject.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "environment"

    productFlavors {
        File("properties").walkTopDown().forEach {
            val split = it.name.split(".")
            if (split.size == 2) {
                val flavor = split[0]
                println("Flavor: $flavor")
                create(flavor) {
                    val properties = getProperties(getPropertiesFileName(flavor))
                    dimension = "environment"
                    buildProperties(properties) { k, v ->
                        buildConfigField("String", k.uppercase(), "\"$v\"")
                    }
                }
            }
        }
    }
    sourceSets {
        File("properties").walkTopDown().forEach {
            val split = it.name.split(".")
            if (split.size == 2) {
                val flavor = split[0]
                getByName(flavor).res.srcDirs("src/${flavor}/res")
            }
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
        buildConfig = true
        viewBinding = true
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = PunkooProject.COMPOSE_COMPILER_VERSION
    }
}

dependencies {
    // App dependencies
    implementation(project(Modules.STYLES))
    api(project(Modules.COMMON))
    implementation(project(Modules.BEER))

    // Android dependencies
    implementation(androidLibs.activity)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.materialCompose)
    implementation(androidLibs.material)
    implementation(androidLibs.navigation)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.paging)
    implementation(androidLibs.lifecycleViewModel)
    implementation(androidLibs.lifecycleRuntime)
    implementation(androidLibs.hiltAndroid)
    kapt(androidLibs.hiltCompiler)

    // Tooling Preview
    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    // Networking dependencies
    implementation(networkingLibs.retrofit)
    implementation(networkingLibs.retrofitConverter)
    implementation(networkingLibs.loggingInterceptor)
    implementation(networkingLibs.moshi)
    implementation(networkingLibs.moshiAdapters)
    kapt(networkingLibs.moshiKapt)
    debugImplementation(networkingLibs.chucker)
    releaseImplementation(networkingLibs.chuckerNoOp)

    // Third Party dependencies
    implementation(thirdPartyLibs.coil)
    implementation(thirdPartyLibs.arrowCore)

    // Test dependencies
    testImplementation(testLibs.junit)
    testImplementation(testLibs.mockk)
    testImplementation(testLibs.archCoreTesting)
    testImplementation(testLibs.coroutinesTest)
    testImplementation(testLibs.testCore)
    androidTestImplementation(testLibs.junitTest)
    androidTestImplementation(androidLibs.uiTestJunit4)
    androidTestImplementation(testLibs.espresso)

}