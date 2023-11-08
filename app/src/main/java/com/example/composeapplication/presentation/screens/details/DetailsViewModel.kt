package com.example.composeapplication.presentation.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.domain.use_cases.DetailInfoUseCase
import com.example.composeapplication.presentation.screens.blogs.BlogsAppState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailInfoUseCase: DetailInfoUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var detailState: DetailAppState by mutableStateOf(DetailAppState.Loading)
        private set

    var isLoaded by mutableStateOf(false)

    init {

        savedStateHandle.get<Int>("id").let {

            viewModelScope.launch {
                detailState = DetailAppState.Loading

                try {
                    if (it != null) {
                        val detailInfo = detailInfoUseCase.getDetailInfoUseCase.getDetailInfo(it)

                        if (detailInfo.success) {
                            val content = detailInfo.detailData.content

                            val regexWidthStart = Regex("!\\[(.*?) width=\\]")

                            val regexWidthEnd = Regex("\"\" width=\"")

                            val withoutWidth = regexWidthStart.replace(content, "![Image]")

                            val withoutWidth1 = regexWidthEnd.replace(withoutWidth, "")

                            detailState = DetailAppState.OnSuccessContents(
                                detailInfo.detailData.title,
                                detailInfo.detailData.detailImage.md,
                                withoutWidth1
                            )
                        }else{
                            detailState = DetailAppState.Error(detailInfo.error)
                        }
                    }

                } catch (e: Exception) {
                   detailState = DetailAppState.Error(e.message.toString())
                }
            }
        }
    }

    fun imageLoaded(b: Boolean) {
        isLoaded = b
    }
}