// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("cn.therouter") version "1.1.1" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}