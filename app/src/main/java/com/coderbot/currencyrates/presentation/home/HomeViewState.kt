package com.coderbot.currencyrates.presentation.home

import com.coderbot.currencyrates.data.model.CurrencyRate

sealed class HomeViewState
{
    class DataState(val rates: MutableList<CurrencyRate>) : HomeViewState()
    class ErrorState(val error: Throwable) : HomeViewState()
    object LoadingState : HomeViewState()
}