plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Android.compileSdk
    namespace = "com.alextfos.punkoo"

    defaultConfig {
        applicationId = "com.alextfos.punkoo"
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode

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
            if (split.size == 3) {
                val flavor = split[0]
                val env = split[1]
                val baseProperties = getProperties("properties/$flavor.properties")
                println("Flavor: $flavor| Environment: $env")
                create("$flavor${capitalize(env)}") {
                    val properties = getProperties(getPropertiesFileName(flavor, env))

                    applicationId = baseProperties.getProperty("build_application_id") ?: ""
                    versionName =
                        baseProperties.getProperty("build_version_name") ?: Android.versionName
                    versionCode = baseProperties.getProperty("build_version_code")?.toInt() ?: Android.versionCode
                    dimension = "environment"
                    applicationIdSuffix = applySuffix(env)
                    buildProperties(properties) { k, v ->
                        buildConfigField("String", k.toUpperCase(), "\"$v\"")
                    }
                }
            }
        }
    }
    sourceSets {
        File("properties").walkTopDown().forEach {
            val split = it.name.split(".")
            if (split.size == 3) {
                val flavor = split[0]
                val env = split[1]
                getByName("$flavor${capitalize(env)}").res.srcDirs("src/${flavor}/res")
            }
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

    implementation(Material.material)

    implementation(Compose.activity)
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