package com.example.composeapplication.domain.use_cases

import com.example.composeapplication.data.repository.GetBlogsImpl
import com.example.composeapplication.domain.model.ContentInfo


class GetContentsUseCase (val repository: GetBlogsImpl) {

    suspend fun getContents(): ContentInfo {
        return repository.getContents()
    }

}