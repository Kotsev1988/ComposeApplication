package com.example.composeapplication.data.repository

import com.example.composeapplication.data.api.ITourAPI
import com.example.composeapplication.domain.model.ContentInfo
import com.example.composeapplication.domain.model.DetailInfo
import com.example.composeapplication.domain.repository.IGetBlogs

class GetBlogsImpl(
    private val api: ITourAPI
): IGetBlogs {
    override suspend fun getContents(): ContentInfo =
         api.getContent()


    override suspend fun getDetailInfo(id: Int): DetailInfo =
        api.getDetailInfo(id)

}