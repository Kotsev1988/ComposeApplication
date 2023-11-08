package com.example.composeapplication.domain.use_cases

import com.example.composeapplication.data.repository.GetBlogsImpl
import com.example.composeapplication.domain.model.DetailInfo


class GetDetailInfoUseCase (val repository: GetBlogsImpl) {

    suspend fun getDetailInfo(id: Int): DetailInfo {
        return repository.getDetailInfo(id)
    }

}