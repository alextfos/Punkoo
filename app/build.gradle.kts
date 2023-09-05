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
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
}

dependencies {
    implementation(project(Modules.styles))
    api(project(Modules.common))
    implementation(project(Modules.beer))

    implementation(androidLibs.material)

    implementation(androidLibs.activity)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.coilCompose)
    implementation(Compose.tooling)
    implementation(Compose.navigation)
    implementation(Compose.hiltNavigation)
    implementation(Compose.runtimeLivedata)
    implementation(Compose.coilSvgCompose)
    implementation(AndroidX.lifecycleCompose)
    implementation(Compose.pagingCompose)

    implementation(Api.retrofit)
    implementation(Api.retrofitConverter)
    implementation(Api.httpLoggingInterceptor)
    implementation(Api.arrowCore)
    implementation(Api.moshi)
    implementation(Api.moshiAdapters)

    implementation(AndroidX.lifecycleViewModel)
    implementation(AndroidX.lifecycleRuntime)

    implementation(Hilt.android)
    kapt(Api.moshiKapt)
    kapt(Hilt.compiler)

    testImplementation(Test.junit)
    testImplementation(Test.mockk)
    testImplementation(Test.archCore)
    testImplementation(Test.coroutinesTest)
    testImplementation(Test.testCore)
    androidTestImplementation(Test.junitTest)
    androidTestImplementation(ComposeTest.uiTestJunit4)
    androidTestImplementation(Test.espressoCore)

    debugImplementation(Compose.toolingPreview)
    debugImplementation(Compose.poolingContainer)
    debugImplementation(Api.chucker)
    releaseImplementation(Api.chuckerNoOp)
}