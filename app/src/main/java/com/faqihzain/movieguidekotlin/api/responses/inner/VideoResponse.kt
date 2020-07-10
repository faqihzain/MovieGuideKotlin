package com.faqihzain.movieguidekotlin.api.responses.inner

import com.faqihzain.movieguidekotlin.models.Video
import com.google.gson.annotations.SerializedName

class VideoResponse {
    @SerializedName("results")
    val videos:List<Video>?=null
}