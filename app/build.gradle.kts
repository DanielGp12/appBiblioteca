plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.proyectobiblioteca"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.proyectobiblioteca"
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    //animaciones
    implementation("com.airbnb.android:lottie:6.6.6")
    implementation ("com.google.android.material:material:1.6.0")
    implementation ("com.google.android.material:material:1.6.0") // o la última versión
    implementation(libs.material)

    // Retrofit + GSON
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")


    //Biblioteca
    implementation ("androidx.recyclerview:recyclerview:1.3.2")

    //BARRA DE NAVEGACION
    implementation ("com.google.android.material:material:1.6.0")



    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.annotation)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}