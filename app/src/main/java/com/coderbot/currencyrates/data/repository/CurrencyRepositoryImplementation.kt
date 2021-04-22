package com.coderbot.currencyrates.data.repository

import com.coderbot.currencyrates.data.api.CurrencyAPIs
import com.coderbot.currencyrates.domain.repository.CurrencyRepository
import retrofit2.Retrofit

class CurrencyRepositoryImplementation constructor(retrofit: Retrofit) : CurrencyRepository
{
    private var currencyRates: HashMap<String, Double>? = null

    private val api = retrofit.create(CurrencyAPIs::class.java)

    override fun currencyRates(): HashMap<String, Double>? = currencyRates

    override suspend fun getCurrencyRates(): HashMap<String, Double>
    {
        val response = api.getCurrencyRates()
        return if (response.iSuccessful && response.rates != null)
        {
            currencyRates = response.rates
            currencyRates!!
        }
        else hashMapOf()
    }
}