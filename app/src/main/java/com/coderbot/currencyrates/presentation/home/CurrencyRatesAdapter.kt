package com.coderbot.currencyrates.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coderbot.currencyrates.data.model.CurrencyRate
import com.coderbot.currencyrates.databinding.ViewCurrencyRateItemBinding
import com.coderbot.currencyrates.utils.approximate
import java.util.*

class CurrencyRatesAdapter(private val context: Context, private val listener: (CurrencyRate) -> Unit) : RecyclerView.Adapter<CurrencyRatesAdapter.ViewHolder>()
{
    private var rates: MutableList<CurrencyRate> = mutableListOf()

    fun setData(rates: MutableList<CurrencyRate>)
    {
        this.rates = mutableListOf()
        this.rates.addAll(rates)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ViewCurrencyRateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = rates.size

    private fun getItem(position: Int) = rates[position]

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = getItem(position)
        val flag = context.resources.getIdentifier("flag_${item.currency.toLowerCase(Locale.ENGLISH)}", "drawable", "com.coderbot.currencyrates")
        holder.binding.currency.text = item.currency
        holder.binding.currency.setCompoundDrawablesRelativeWithIntrinsicBounds(flag, 0, 0, 0)
        holder.binding.rate.text = item.rate.approximate(2)
    }

    inner class ViewHolder(val binding: ViewCurrencyRateItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        init
        {
            binding.root.setOnClickListener { listener(getItem(layoutPosition)) }
        }
    }
}