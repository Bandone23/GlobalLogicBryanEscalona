package com.bancosantander.globallogicbryanescalona.di

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.room.Room
import com.bancosantander.globallogicbryanescalona.util.AppPreferences
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

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

/* Firebase */
/*factory { LoginRemoteFire() }
factory { ParkingRemoteFire() }
factory { DashRemoteFire() }
factory { HistoryRemoteFire() }
factory { AssistanceRemoteFire() }
factory { SettingRemoteFire() }
factory { DiscountsRemoteFire() }*/

/* DataSource */
/*factory { LoginLocalDataSource(get()) }
factory { ParkingLocalDataSource(get()) }
factory { ParkingRemoteDataSource(get()) }
factory { TariffLocalDataSource(get()) }
factory { LoginRemoteDataSource(get()) }
factory { DashRemoteDataSource(get()) }
factory { HistoryRemoteDataSource(get()) }
factory { AssistanceRemoteDataSource(get()) }
factory { SettingRemoteDataSource(get()) }
factory { DiscountsRemoteDataSource(get()) }
*//* Repositories *//*
factory { UserLoginRepository(get(), get()) }
factory { ParkingRepository(get(), get()) }
factory { TariffRepository(get()) }
factory { DashRepository(get()) }
factory { HistoryRepository(get()) }
factory { AssistanceRepository(get()) }
factory { SettingRepository(get()) }
factory { DiscountsRepository(get()) }
*//* UseCases *//*
factory { GetUserLoginUseCase(get()) }
factory { SaveUserLoginUseCase(get()) }
factory { SaveLoginRemoteUseCase(get()) }
factory { GetParkingUseCase(get()) }
factory { SaveParkingUseCase(get()) }
factory { SaveParkingRemoteUseCase(get()) }
factory { UpdateParkingUseCase(get()) }
factory { UpdateParkingRemoteUseCase(get()) }
factory { UpdateTariffUseCase(get()) }
factory { SaveTariffUseCase(get()) }
factory { GetTariffUseCase(get()) }
factory { UpdateLoginUseCase(get()) }
factory { GetUserLoginRemoteUseCase(get()) }
factory { GetParkingRemoteUseCase(get()) }
factory { GetDashLocalRemoteUseCase(get()) }
factory { UpdateDashParkingRemoteUseCase(get()) }
factory { SaveHistoryRemoteUseCase(get()) }
factory { GetDashHistoryRemoteUseCase(get()) }
factory { GetAssistanceRemoteUseCase(get()) }
factory { SaveAssistanceRemoteUseCase(get()) }
factory { UpdateAssistanceRemoteCaseUse(get()) }
factory { GetUserAllRemoteUseCase(get()) }
factory { GetPasswordSettingRemoteUseCase(get()) }
factory { GetHistoryCloseRemoteUseCase(get()) }
factory { GetDiscountsRemoteUseCase(get()) }
factory { GetDocParkingRemoteUseCase(get()) }
factory { SaveDiscountDefaultRemoteCaseUse(get()) }
factory { UpdatePasswordSettingRemoteUseCase(get()) }
factory { GetLocalDiscountRemoteUseCase(get()) }
factory { UpdateStateDiscountRemoteCaseUse(get()) }
factory { UpdateInfoDiscountCreatedRemoteUseCase(get()) }
factory { SaveNewDiscountRemoteUseCase(get()) }*/

/* View models */
/*viewModel { UserLoginViewModel(get(), get(), get(), get(), get(),get(),get(),get()) }
viewModel { ParkingViewModel(get(), get(), get(), get(), get(), get(), get(), get(),get(),get(),get(),get()) }
viewModel { TariffViewModel(get(), get(), get(),get()) }
viewModel { DashViewModel(get(), get(), get(),get(),get(),get(),get(),get(),get(),get(),get(),get()) }
viewModel { HistoryViewModel(get()) }
viewModel { AssistanceViewModel(get(),get(),get(),get()) }*/


/* Picasso */
    single {
        Picasso.get()
    }
}
