package com.example.composeapplication.domain.repository

import com.example.composeapplication.domain.model.ContentInfo
import com.example.composeapplication.domain.model.DetailInfo

interface IGetBlogs {

    suspend fun getContents(): ContentInfo
    suspend fun getDetailInfo(id: Int): DetailInfo

}