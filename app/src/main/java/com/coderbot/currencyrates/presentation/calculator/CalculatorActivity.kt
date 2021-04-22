package com.coderbot.currencyrates.presentation.calculator

import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.coderbot.currencyrates.R
import com.coderbot.currencyrates.databinding.ActivityCalculatorBinding
import com.coderbot.currencyrates.presentation.base.AppActivity
import com.coderbot.currencyrates.utils.approximate

class CalculatorActivity : AppActivity()
{
    private var currency = ""
    private var rate = 0.0
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currency = intent.getStringExtra("CURRENCY") ?: ""
        rate = intent.getDoubleExtra("RATE", 0.0)

        init()
    }

    private fun init()
    {
        binding.baseCurrency.text = getString(R.string.eur)
        binding.base.setText((1.0).approximate(2))

        binding.resultCurrency.text = currency
        binding.result.text = rate.approximate(2)

        binding.base.addTextChangedListener {
            if (binding.base.text.isNullOrEmpty()) calculate(0.0)
            else calculate(binding.base.text.toString().toDouble())
        }
    }

    private fun calculate(amount: Double)
    {
        binding.result.text = (amount * rate).approximate(2)
    }
}