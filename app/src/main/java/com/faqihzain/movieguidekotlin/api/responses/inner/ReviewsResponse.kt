package com.faqihzain.movieguidekotlin.api.responses.inner

import com.faqihzain.movieguidekotlin.models.Review
import com.google.gson.annotations.SerializedName

class ReviewsResponse {
    @SerializedName("results")
    val reviews:List<Review>?=null
}