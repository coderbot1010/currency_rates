package com.coderbot.currencyrates.domain.mapper

import com.coderbot.currencyrates.data.model.CurrencyRate

object CurrencyRateMapper
{
    fun map(rates: HashMap<String, Double>): MutableList<CurrencyRate>
    {
        val currencyRates = mutableListOf<CurrencyRate>()
        rates.forEach { (key, value) -> currencyRates.add(CurrencyRate(key, value)) }
        return currencyRates
    }
}