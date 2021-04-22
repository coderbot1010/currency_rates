package com.coderbot.currencyrates.presentation.home

import com.coderbot.currencyrates.domain.usecase.GetCurrencyRates
import com.coderbot.currencyrates.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val getCurrencyRates: GetCurrencyRates) : BaseViewModel<HomeViewState>()
{
    fun getCurrencyRates() = CoroutineScope(Dispatchers.IO).launch {
        getCurrencyRates.run().catch { error ->
            state.postValue(HomeViewState.ErrorState(error))
        }.collect {
            state.postValue(HomeViewState.DataState(it))
        }
    }
}