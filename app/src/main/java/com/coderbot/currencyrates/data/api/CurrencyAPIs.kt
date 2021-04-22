package com.coderbot.currencyrates.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.coderbot.currencyrates.BuildConfig

interface CurrencyAPIs
{
    @GET("latest")
    suspend fun getCurrencyRates(@Query("access_key") apiKey: String = BuildConfig.API_KEY): Response<HashMap<String, Double>>
}