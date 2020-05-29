package com.bancosantander.globallogicbryanescalona.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.room.Room
import com.bancosantander.globallogicbryanescalona.URL_BASE_API
import com.bancosantander.globallogicbryanescalona.data.local.database.AppDatabase
import com.bancosantander.globallogicbryanescalona.data.local.source.SongLocalDataSource
import com.bancosantander.globallogicbryanescalona.data.remote.net.SongRemoteApi
import com.bancosantander.globallogicbryanescalona.data.remote.source.SongRemoteDataSource
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetAlbumLocalUseCase
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetAlbumUseCase
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongLocalUseCase
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongUseCase
import com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.detail.AlbumViewModel
import com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search.SearchViewModel
import com.bancosantander.globallogicbryanescalona.util.AppPreferences
import com.bancosantander.globallogicbryanescalona.util.DATABASE_NAME
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
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

    /* Api*/
    single { get<Retrofit>().create(SongRemoteApi::class.java) as SongRemoteApi }

    /* Database */
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
    }
    /* Dao Interfaces */
    factory { get<AppDatabase>().songListDao() }
    factory { get<AppDatabase>().albumDao() }


/* DataSource */
    factory { SongRemoteDataSource(get()) }
    factory { SongLocalDataSource(get(),get()) }

    /* Repositories */
    factory { SongRepository(get(),get()) }

    /* UseCases */
    factory { GetSongUseCase(get()) }
    factory { GetAlbumUseCase(get()) }
    factory { GetAlbumLocalUseCase(get()) }
    factory { GetSongLocalUseCase(get()) }
    /* View models */
    viewModel { SearchViewModel(get(),get()) }
    viewModel { AlbumViewModel(get(),get()) }


/* Picasso */
    single {
        Picasso.get()
    }
}
