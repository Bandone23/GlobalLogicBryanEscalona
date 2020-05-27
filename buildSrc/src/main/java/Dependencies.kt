object ApplicationId {
    val id = "com.bancosantander.globallogicbryanescalona"
}

object Modules {
    val app = ":app"
    val core = ":core"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val gradle = "3.4.2"

    val compileSdk = 29
    val minSdk = 22
    val targetSdk = 29
    val buildToolsVersion = "29.0.3"

    val googleAuth = "16.0.1"

    val googleServices = "4.3.0"

    val firebaseAuth = "16.0.4"
    val firebaseCore = "16.0.4"

    val fabric = "1.30.0"

    val appcompat = "1.0.2"
    val design = "1.1.0-alpha04"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val maps = "15.0.1"

    val ktx = "1.0.0-alpha1"

    val kotlin = "1.3.41"
    val timber = "4.7.1"
    val rxjava = "2.2.10"
    val rxkotlin = "2.3.0"
    val rxAndroidVersion = "2.1.1"
    val retrofit = "2.6.0"
    val loggingInterceptor = "4.0.0"
    val glide = "4.9.0"
    val rxpaper = "1.4.0"
    val paperdb = "2.6"
    val picasso = "2.71828"
    val moshi = "1.8.0"
    val lifecycle = "2.0.0"
    val leakCanary = "2.0-alpha-2"
    val crashlytics = "2.10.1"
    val koin = "2.0.0-beta-1"

    val playCore = "1.6.1"

    val junit = "4.12"
    val assertjCore = "3.12.2"

    val truthVersion = "1.0"
    val truthExtVersion = "1.3.0-alpha01"
    val mockKVersion = "1.9.3"

    val coroutines = "1.2.1"
    val livedata = "2.1.0"
    val legacyv4 = "1.0.0"
    val constraintL = "1.1.3"
    val extestJunit = "1.1.1"
    val espresso = "3.2.0"
    val circleimg = "3.0.0"
    val okhttp = "3.14.2"
    val room ="2.1.0"
    val navVersion = "2.3.0-alpha06"
    val threetena ="1.2.1"


}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitgson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"

    val paperdb = "io.paperdb:paperdb:${Versions.paperdb}"
    val rxpaper = "com.github.pakoito:RxPaper2:${Versions.rxpaper}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"

    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    val leakCanaryAndroid = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    val coroutinescore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesandroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val threetena  ="com.jakewharton.threetenabp:threetenabp:${Versions.threetena}"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val livedata = "androidx.lifecycle:lifecycle-livedata:${Versions.livedata}"
    val lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val legacy_v4 = "androidx.legacy:legacy-support-v4:${Versions.legacyv4}"
    val constraintL = "androidx.constraintlayout:constraintlayout:${Versions.constraintL}"
    val circleimg = "de.hdodenhof:circleimageview:${Versions.circleimg}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
   val room = "androidx.room:room-runtime:${Versions.room}"
   val roomKtx= "androidx.room:room-ktx:${Versions.room}"
}

object GoogleLibraries {
    val auth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"
    val playCore = "com.google.android.play:core:${Versions.playCore}"
}

object FirebaseLibraries {
    val auth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"
    val core = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    val mockK = "io.mockk:mockk:${Versions.mockKVersion}"
    val truth = "com.google.truth:truth:${Versions.truthVersion}"
    val truthExt = "androidx.test.ext:truth:${Versions.truthExtVersion}"
    val extestJunit = "androidx.test.ext:junit:${Versions.extestJunit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object JetPackCompose {
     val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
     val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
}

