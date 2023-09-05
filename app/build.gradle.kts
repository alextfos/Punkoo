plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = PunkooProject.compileSdk
    namespace = PunkooProject.applicationId

    defaultConfig {
        applicationId = PunkooProject.applicationId
        minSdk = PunkooProject.minSdk
        targetSdk = PunkooProject.targetSdk
        versionCode = PunkooProject.versionCode
        versionName = PunkooProject.versionName

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
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
        kotlinCompilerExtensionVersion = Build.composeCompilerVersion
    }
}

dependencies {
    implementation(project(Modules.styles))
    api(project(Modules.common))
    implementation(project(Modules.beer))

    implementation(androidLibs.activity)
    implementation(androidLibs.composeUi)
    implementation(androidLibs.material)
    implementation(thirdPartyLibs.coil)
    implementation(androidLibs.navigation)
    implementation(androidLibs.runtimeLiveData)
    implementation(androidLibs.paging)

    // Networking
    implementation(networkingLibs.retrofit)
    implementation(networkingLibs.retrofitConverter)
    implementation(networkingLibs.loggingInterceptor)
    implementation(thirdPartyLibs.arrowCore)
    implementation(networkingLibs.moshi)
    implementation(networkingLibs.moshiAdapters)

    implementation(androidLibs.lifecycleViewModel)
    implementation(androidLibs.lifecycleRuntime)

    implementation(androidLibs.hiltAndroid)
    kapt(androidLibs.hiltCompiler)

    kapt(networkingLibs.moshiKapt)

    testImplementation(Test.junit)
    testImplementation(Test.mockk)
    testImplementation(Test.archCore)
    testImplementation(Test.coroutinesTest)
    testImplementation(Test.testCore)
    androidTestImplementation(Test.junitTest)
    androidTestImplementation(androidLibs.uiTestJunit4)
    androidTestImplementation(Test.espressoCore)

    implementation(androidLibs.tooling)
    debugImplementation(androidLibs.toolingPreview)
    debugImplementation(androidLibs.poolingContainer)

    debugImplementation(networkingLibs.chucker)
    releaseImplementation(networkingLibs.chuckerNoOp)
}