# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.kts
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# need add for Fragment page route
# -keep public class * extends android.app.Fragment
# -keep public class * extends androidx.fragment.app.Fragment
# -keep public class * extends android.support.v4.app.Fragment


# -------------------------------------- TheRouter -------------------------------------------------
-keep class androidx.annotation.Keep
-keep @androidx.annotation.Keep class * {*;}
-keepclassmembers class * {
    @androidx.annotation.Keep *;
}
-keepclasseswithmembers class * {
    @androidx.annotation.Keep <methods>;
}
-keepclasseswithmembers class * {
    @androidx.annotation.Keep <fields>;
}
-keepclasseswithmembers class * {
    @androidx.annotation.Keep <init>(...);
}
-keepclasseswithmembers class * {
    @com.therouter.router.Autowired <fields>;
}