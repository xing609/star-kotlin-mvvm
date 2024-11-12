import com.miyue.buildsrc.*

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.star.lib_common"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        viewBinding = true
    }
}

dependencies {
    implementation(DependenciesLibs.coreKtx)
    implementation(DependenciesLibs.appcompat)
    implementation(DependenciesLibs.material)
    implementation(DependenciesLibs.constraintlayout)
    implementation(DependenciesLibs.multidex)
    implementation(DependenciesLibs.materialDialogsLifecycle)
    implementation(DependenciesLibs.materialDialogsCore)
    implementation(DependenciesLibs.toaster)
    implementation(DependenciesLibs.utilcodex)
    implementation(DependenciesLibs.liveDataKtx)
    implementation(DependenciesLibs.viewModelKtx)
    implementation(DependenciesLibs.gson)
    implementation(DependenciesLibs.retrofit2)
    implementation(DependenciesLibs.retrofit2Gson)
    implementation(DependenciesLibs.loggingInterceptor)

    implementation(DependenciesLibs.datastore)

    implementation(DependenciesLibs.coroutinesCore)

    kapt(DependenciesLibs.therouterApt)
    implementation(DependenciesLibs.therouter)
}