package com.coderbot.currencyrates.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coderbot.currencyrates.presentation.loading.LoadingDialog

abstract class AppActivity : AppCompatActivity()
{
    private lateinit var loading: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        loading = LoadingDialog(this@AppActivity)
    }

    fun showLoading()
    {
        if (!loading.isShowing)
        {
            loading.show()
        }
    }

    fun dismissLoading()
    {
        if (loading.isShowing)
        {
            loading.dismiss()
        }
    }
}