package com.coderbot.currencyrates.application

import com.coderbot.currencyrates.BuildConfig
import com.coderbot.currencyrates.data.repository.*
import com.coderbot.currencyrates.domain.repository.*
import com.coderbot.currencyrates.domain.usecase.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinModule = module {

    single { provideRetrofit() }

    single { CurrencyRepositoryImplementation(get()) as CurrencyRepository }

    single { GetCurrencyRates(get()) }

    // viewModel { SplashViewModel(get()) }
}

fun provideRetrofit(): Retrofit
{
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
}