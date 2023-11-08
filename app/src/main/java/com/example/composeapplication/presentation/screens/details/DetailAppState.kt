package com.example.composeapplication.presentation.screens.details

sealed class DetailAppState {

    data class OnSuccessContents(
        val title: String,
        val imageUrl: String,
        val content: String
    ): DetailAppState()

    data class Error(val error: String) : DetailAppState()
    object Loading : DetailAppState()


}
