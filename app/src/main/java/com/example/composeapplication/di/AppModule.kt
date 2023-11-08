package com.example.composeapplication.di

import com.example.composeapplication.data.api.ITourAPI
import com.example.composeapplication.data.repository.GetBlogsImpl
import com.example.composeapplication.domain.use_cases.ContentsUseCase
import com.example.composeapplication.domain.use_cases.DetailInfoUseCase
import com.example.composeapplication.domain.use_cases.GetContentsUseCase
import com.example.composeapplication.domain.use_cases.GetDetailInfoUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesGetBlogsImpl(api: ITourAPI) = GetBlogsImpl(api)


    @Provides
    @Singleton
    fun providesContentsUseCases(repository: GetBlogsImpl): ContentsUseCase = ContentsUseCase(
        getContentsUseCase = GetContentsUseCase(repository)
    )

    @Provides
    @Singleton
    fun providesContentInfoUseCases(repository: GetBlogsImpl): DetailInfoUseCase = DetailInfoUseCase(
        getDetailInfoUseCase = GetDetailInfoUseCase(repository)
    )


    @Named("baseURL")
    @Provides
    fun baseURL(): String = "https://rsttur.ru"

    @Singleton
    @Provides
    fun api(@Named("baseURL") baseURL: String, gson: Gson): ITourAPI =
        Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ITourAPI::class.java)

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder().setLenient().create()


}

