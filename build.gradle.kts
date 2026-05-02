plugins {
 alias(libs.plugins.android.application)
}
android {
 namespace = "com.example.newsfeed"
 compileSdk = 36
 defaultConfig {
 applicationId = "com.example.newsfeed"
 minSdk = 24
 targetSdk = 36
 versionCode = 1
 versionName = "1.0"
 testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
 
 // Please replace with your actual API key from newsapi.org
buildConfigField("String", "NEWS_API_KEY", 
"\"dd214e2ef2d84026892205aee61ae6b3\"")
 }
 buildTypes {
 release {
 isMinifyEnabled = false
 proguardFiles(
 getDefaultProguardFile("proguard-android-optimize.txt"),
 "proguard-rules.pro"
 )
 }
 }
 compileOptions {
 sourceCompatibility = JavaVersion.VERSION_11
 targetCompatibility = JavaVersion.VERSION_11
 }
 buildFeatures {
 viewBinding = true
 buildConfig = true
 }
}
dependencies {
 implementation(libs.appcompat)
 implementation(libs.material)
 implementation(libs.activity)
 implementation(libs.constraintlayout)
 implementation(libs.retrofit)
 implementation(libs.retrofit.gson)
 implementation(libs.okhttp.logging)
 implementation(libs.glide)
 implementation(libs.lifecycle.viewmodel)
 implementation(libs.lifecycle.livedata)
 implementation(libs.swiperefreshlayout)
 testImplementation(libs.junit)
 androidTestImplementation(libs.ext.junit)
 androidTestImplementation(libs.espresso.core)
}
