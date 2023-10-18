plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.dannxvc.todoapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.dannxvc.todoapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        configurations.implementation {     exclude("org.jetbrains.kotlin", "kotlin-stdlib-jdk7") }
        configurations.implementation {     exclude("org.jetbrains.kotlin", "kotlin-stdlib-jdk8") }
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

}

dependencies {
    val nav_version = "2.7.4"
    val lifecycle_version = "2.2.0"

    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-analytics-ktx")


}
