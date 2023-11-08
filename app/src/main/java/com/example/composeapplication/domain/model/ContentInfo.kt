package com.example.composeapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ContentInfo(
    @SerializedName("data")
    val contentInfo: List<ContentData>,
    val error: String,
    val success: Boolean,
    val time: String
)