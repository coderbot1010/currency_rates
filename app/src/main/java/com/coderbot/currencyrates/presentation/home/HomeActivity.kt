package com.coderbot.currencyrates.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.coderbot.currencyrates.R
import com.coderbot.currencyrates.data.model.CurrencyRate
import com.coderbot.currencyrates.databinding.ActivityHomeBinding
import com.coderbot.currencyrates.presentation.base.AppActivity
import com.coderbot.currencyrates.presentation.calculator.CalculatorActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppActivity()
{
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: CurrencyRatesAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.state.observe(this@HomeActivity, { state -> setView(state) })

        init()
    }

    override fun onResume()
    {
        super.onResume()
        setView(HomeViewState.LoadingState)
        viewModel.getCurrencyRates()
    }

    private fun init()
    {
        adapter = CurrencyRatesAdapter(this@HomeActivity) { openCalculator(it) }
        binding.rates.setHasFixedSize(false)
        binding.rates.isNestedScrollingEnabled = false
        binding.rates.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.rates.adapter = adapter
        adapter.setData(mutableListOf())
    }

    private fun setView(state: HomeViewState)
    {
        when (state)
        {
            is HomeViewState.LoadingState -> showLoading()
            is HomeViewState.DataState -> setData(state.rates)
            is HomeViewState.ErrorState -> showError(state.error.message ?: getString(R.string.general_error))
        }
    }

    private fun setData(rates: MutableList<CurrencyRate>)
    {
        dismissLoading()
        adapter.setData(rates)
    }

    private fun showError(error: String)
    {
        dismissLoading()
        Snackbar.make(binding.mainView, error, Snackbar.LENGTH_LONG).setAction(getString(R.string.ok)) { }.show()
    }

    private fun openCalculator(currencyRate: CurrencyRate)
    {
        startActivity(Intent(this@HomeActivity, CalculatorActivity::class.java).putExtra("CURRENCY", currencyRate.currency).putExtra("RATE", currencyRate.rate))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}