package com.example.composeapplication.domain.model

import com.google.gson.annotations.SerializedName

data class DetailData(
    val content: String,
    val date: String,
    val id: Int,
    @SerializedName("image")
    val detailImage: DetailImage,
    val like: Int,
    val subtitle: String,
    val title: String,
    val url: String
)