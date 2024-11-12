import com.miyue.buildsrc.*
import com.miyue.buildsrc.Versions.versionName

// 公用的插件
plugins {
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.android.library")
}
// 根据打包模式使用的插件
if (!Super.isModule) {
    apply(plugin = "com.android.library")
} else {
    apply(plugin = "com.android.application")
    apply(plugin = "therouter")
}

android {
    namespace = "com.binyouwei.module_main"
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
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
    // 源集 —— 用来设置Java目录或者资源目录
    sourceSets {
        getByName("main") {
            if (!Super.isModule) {
//                // 集成化模式，整个项目打包时使用该文件
//                manifest.srcFile = "src/main/AndroidManifest.xml"
//                java {
//                    // release 时 debug 目录下的Java文件不需要合并到主工程
//                    exclude = "**/debug/**"
//                }
            } else {
//                // 如果是组件化模式，需要单独运行时使用该文件
//                manifest.srcFile = "src/main/java/debug/AndroidManifest.xml"
            }
        }
    }

//    android.libraryVariants.all {
//        outputs.all {
//            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
//                this.outputFileName = "测试.apk"
//            }
//        }
//    }
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
}