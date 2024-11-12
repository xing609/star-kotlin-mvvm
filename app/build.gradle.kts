import com.miyue.buildsrc.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("therouter")
}

android {
    namespace = "com.star.mvvm"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.star.mvvm"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        ndk {
            // 设置支持的SO库架构
            abiFilters += listOf("armeabi") //, 'x86', 'armeabi-v7a', 'x86_64', 'arm64-v8a'
        }
    }
    // 打包配置
    signingConfigs {
        getByName("debug") {
            storeFile = file("../mvvm.jks")
            storePassword = SigningConfig.storePassword
            keyAlias = SigningConfig.keyAlias
            keyPassword = SigningConfig.keyPassword
        }
        create("release") {
            storeFile = file("../mvvm.jks")
            storePassword = SigningConfig.storePassword
            keyAlias = SigningConfig.keyAlias
            keyPassword = SigningConfig.keyPassword
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // jniLibs目录指向libs目录
    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("libs")
        }
    }

    // release打包时自定义apk名字、输出路径
    android.applicationVariants.all {
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                this.outputFileName = "xxxx.apk"
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
        viewBinding = true
    }
}

kapt {
    // 把Kotlin的代码生成 .class stubs，以处理注解。
    generateStubs = true
    // 启用布局缓存
    useBuildCache = true
    javacOptions {
        // 增加注解处理器的最大错误次数,默认为100
        option("-Xmaxerrs", 500)
    }
}

dependencies {
    implementation(DependenciesLibs.coreKtx)
    implementation(DependenciesLibs.appcompat)
    implementation(DependenciesLibs.material)
    implementation(DependenciesLibs.constraintlayout)
    implementation(DependenciesLibs.multidex)
    implementation(DependenciesLibs.toaster)
    implementation(DependenciesLibs.utilcodex)
    kapt(DependenciesLibs.therouterApt)
    implementation(DependenciesLibs.therouter)
    implementation(DependenciesLibs.coroutinesCore)
    implementation(project(":lib_common"))
    implementation(project(":module_main"))
}