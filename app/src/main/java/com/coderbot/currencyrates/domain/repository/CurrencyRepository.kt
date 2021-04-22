package com.coderbot.currencyrates.domain.repository

interface CurrencyRepository
{
    fun currencyRates(): HashMap<String, Double>?

    suspend fun getCurrencyRates(): HashMap<String, Double>
}