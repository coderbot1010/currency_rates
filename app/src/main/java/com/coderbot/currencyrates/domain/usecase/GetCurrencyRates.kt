package com.coderbot.currencyrates.domain.usecase

import com.coderbot.currencyrates.domain.repository.CurrencyRepository

class GetCurrencyRates constructor(private val repository: CurrencyRepository)
{

}