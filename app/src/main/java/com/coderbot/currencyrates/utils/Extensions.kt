package com.coderbot.currencyrates.utils

fun Double.approximate(digits: Int) = "%.${digits}f".format(this)