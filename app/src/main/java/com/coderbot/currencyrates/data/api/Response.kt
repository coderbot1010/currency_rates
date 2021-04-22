package com.coderbot.currencyrates.data.api

import com.google.gson.annotations.SerializedName

data class Response<RESPONSE>
(
        @SerializedName("rates") var rates: RESPONSE?,
        @SerializedName("base") var base: String,
        @SerializedName("date") var date: String,
        @SerializedName("timestamp") var time: Long,
        @SerializedName("success") var iSuccessful: Boolean,
)