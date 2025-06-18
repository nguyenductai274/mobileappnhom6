plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
<<<<<<< HEAD
=======
    id("com.google.gms.google-services")
>>>>>>> 4972998 (Done Đồng hồ đếm ngược - thông báo)
}

android {
    namespace = "com.example.appquanlythoigian"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appquanlythoigian"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
<<<<<<< HEAD
=======
    implementation(libs.androidx.room.common.jvm)
    implementation(libs.play.services.maps)
    implementation(libs.androidx.navigation.runtime.android)
>>>>>>> 4972998 (Done Đồng hồ đếm ngược - thông báo)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

<<<<<<< HEAD
    implementation ("androidx.compose.material:material:1.5.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation("androidx.compose.material3:material3:1.3.2")
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.compose.material:material-icons-extended")
=======
    implementation ("androidx.compose.material:material:1.8.2")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.8.2")
    implementation (libs.androidx.activity.compose.v170)
    implementation(libs.androidx.compose.bom.v20240500)
    implementation(libs.androidx.material.icons.extended)
    implementation ("androidx.navigation:navigation-compose:2.9.0")
    implementation(libs.firebase.bom)
    implementation("com.google.firebase:firebase-analytics:22.4.0")
    implementation(libs.firebase.firestore.ktx)
>>>>>>> 4972998 (Done Đồng hồ đếm ngược - thông báo)
}