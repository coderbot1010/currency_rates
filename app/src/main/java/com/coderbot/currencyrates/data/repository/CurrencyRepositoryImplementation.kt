package com.coderbot.currencyrates.data.repository

import com.coderbot.currencyrates.data.api.CurrencyAPIs
import com.coderbot.currencyrates.domain.repository.CurrencyRepository
import retrofit2.Retrofit

class CurrencyRepositoryImplementation constructor(retrofit: Retrofit) : CurrencyRepository
{
    private val api = retrofit.create(CurrencyAPIs::class.java)
}