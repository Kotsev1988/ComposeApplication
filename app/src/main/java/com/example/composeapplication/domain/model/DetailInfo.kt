package com.example.composeapplication.domain.model

import com.google.gson.annotations.SerializedName

data class DetailInfo(
    @SerializedName("data")
    val detailData: DetailData,
    val error: String,
    val success: Boolean,
    val time: String
)