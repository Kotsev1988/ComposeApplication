package com.example.composeapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ContentData(
    val date: Date,
    val id: Int,
    @SerializedName("image")
    val contentImage: ContentImage,
    val like: Int,
    val subtitle: String,
    val title: String,
    val view: Int
)