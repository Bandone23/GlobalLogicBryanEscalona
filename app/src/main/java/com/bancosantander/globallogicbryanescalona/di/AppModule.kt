package com.bancosantander.globallogicbryanescalona.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.room.Room
import com.bancosantander.globallogicbryanescalona.URL_BASE_API
import com.bancosantander.globallogicbryanescalona.data.remote.source.SongRemoteDatSource
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongUseCase
import com.bancosantander.globallogicbryanescalona.util.AppPreferences
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

/* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            AppPreferences.SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }


    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
/* Database */
/*single {
    Room.databaseBuilder(
        androidApplication(),
        AppDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()
}*/
/* Dao Interfaces */
/*factory { get<AppDatabase>().loginDao() }
factory { get<AppDatabase>().parkingDao() }
factory { get<AppDatabase>().tariffDao() }*/


/* DataSource */
    factory { SongRemoteDatSource(get()) }

    /* Repositories */
    factory { SongRepository(get()) }

    /* UseCases */
    factory { GetSongUseCase(get()) }
 /* View models */
/*
viewModel { UserLoginViewModel(get(), get(), get(), get(), get(),get(),get(),get()) }*/



/* Picasso */
    single {
        Picasso.get()
    }
}
