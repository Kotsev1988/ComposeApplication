package com.example.composeapplication.presentation.screens.blogs

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.domain.use_cases.ContentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BlogsViewModel @Inject constructor(
    private val getContentsUseCase: ContentsUseCase,

    ) : ViewModel() {

    var blogsState: BlogsAppState by mutableStateOf(BlogsAppState.Loading)
        private set

    init {

        viewModelScope.launch {
            blogsState = BlogsAppState.Loading
            try {
                val content = getContentsUseCase.getContentsUseCase.getContents()
                if (content.success) {
                    blogsState = BlogsAppState.OnSuccessContents(content.contentInfo)
                }else{
                    blogsState = BlogsAppState.Error(content.error)
                }
            } catch (e: Exception) {
               blogsState = BlogsAppState.Error(e.message.toString())
            }
        }
    }
}

