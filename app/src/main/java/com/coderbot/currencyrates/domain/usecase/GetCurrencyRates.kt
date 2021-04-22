package com.coderbot.currencyrates.domain.usecase

import com.coderbot.currencyrates.domain.mapper.CurrencyRateMapper
import com.coderbot.currencyrates.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCurrencyRates constructor(private val repository: CurrencyRepository)
{
    fun run() = flow {
        var rates = repository.currencyRates()
        if (rates == null)
        {
            rates = repository.getCurrencyRates()
        }
        emit(CurrencyRateMapper.map(rates))
    }.catch { error ->
        error.printStackTrace()
        throw error
    }.flowOn(Dispatchers.IO)
}