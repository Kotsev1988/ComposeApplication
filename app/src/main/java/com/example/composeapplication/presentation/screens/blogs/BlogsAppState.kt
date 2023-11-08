package com.example.composeapplication.presentation.screens.blogs

import com.example.composeapplication.domain.model.ContentData

sealed class BlogsAppState {

    data class OnSuccessContents(
        val content: List<ContentData>
    ): BlogsAppState()

    data class Error(val error: String) : BlogsAppState()
    object Loading : BlogsAppState()


}
