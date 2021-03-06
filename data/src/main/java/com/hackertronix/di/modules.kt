package com.hackertronix.di

import com.hackertronix.data.local.Covid19StatsDatabase
import com.hackertronix.data.network.provideApiClient
import com.hackertronix.data.network.provideIndianApiClient
import com.hackertronix.data.network.provideTimelinesApiClient
import com.hackertronix.data.repository.CountryStatsRepository
import com.hackertronix.data.repository.OverviewRepository
import com.hackertronix.data.repository.india.IndiaStatsRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    single { provideApiClient() }
    single { provideIndianApiClient() }
    single { provideTimelinesApiClient() }
}

val databaseModule = module {
    single { Covid19StatsDatabase.getDatabase(androidApplication()) }
}

val repositoryModule = module {
    factory { OverviewRepository(get(), get()) }
    factory { IndiaStatsRepository(get(), get()) }
    factory { CountryStatsRepository(get(), get()) }
}