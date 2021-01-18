plugins {
    // Application Specific Plugins
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    buildToolsVersion(AndroidSdk.build)

    defaultConfig {
        applicationId = AndroidClient.appId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = AndroidClient.versionCode
        versionName = AndroidClient.versionName

        testInstrumentationRunner = AndroidClient.testRunner
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    buildTypes {
        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = true
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
}

dependencies {

    // Application dependencies
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.activity)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)

    // Development dependencies
    debugImplementation(DevLibraries.leakCanary)
}