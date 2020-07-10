package com.faqihzain.movieguidekotlin.api.responses.inner

import com.faqihzain.movieguidekotlin.models.Cast
import com.google.gson.annotations.SerializedName

class CreditsResponse {
    @SerializedName("cast")
    val casts:List<Cast>?=null
}