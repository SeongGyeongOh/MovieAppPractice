package com.osg.movieapppractice.data.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/api/v2/list_movies.json?sort_by=like_count&order_by=desc&limit=5")
    suspend fun getMovie(): String
}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://yts.lt")
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

// val apiService: ApiService = retrofit.create(ApiService::class.java)
