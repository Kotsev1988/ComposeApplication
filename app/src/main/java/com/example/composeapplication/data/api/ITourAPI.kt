package com.example.composeapplication.data.api

import com.example.composeapplication.domain.model.ContentInfo
import com.example.composeapplication.domain.model.DetailInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface ITourAPI {

    @GET("/api/base-app/blog?id=117&format=card")
    suspend fun getContent(
    ): ContentInfo
    @GET("/api/base-app/blog-info?id=117")
    suspend fun getDetailInfo(
       @Query("blog_id") id: Int
    ): DetailInfo


//    @GET("v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
//    suspend fun getRooms(): Response<Rooms>
//
//    @GET("v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
//    suspend fun getBooking(): Response<Booking>

}