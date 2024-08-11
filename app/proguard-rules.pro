# Optimization options
-optimizationpasses 5
-dontpreverify
-allowaccessmodification
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# Remove logging and debug information
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
    public static *** w(...);
    public static *** e(...);
}

# Keep data classes and model classes to avoid obfuscation issues
-keep class com.example.yourapp.models.** { *; }

# Keep all annotations
-keepattributes *Annotation*

# Keep public constructors in the app
-keepclassmembers class * {
    public <init>(...);
}

# Keep all classes extending Android's component classes (Activity, Service, BroadcastReceiver, etc.)
-keep class * extends android.app.Activity
-keep class * extends android.app.Service
-keep class * extends android.content.BroadcastReceiver
-keep class * extends android.content.ContentProvider

# Keep all Parcelable implementations
-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
}

# Keep all classes and methods used for DataBinding
-keep class * extends androidx.databinding.* {
    *;
}

# Keep all View Binding classes
-keep class **_ViewBinding {
    *;
}

# Keep Glide generated API
-keep class com.bumptech.glide.** {
    *;
}
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public class * extends com.bumptech.glide.annotation.GlideModule
