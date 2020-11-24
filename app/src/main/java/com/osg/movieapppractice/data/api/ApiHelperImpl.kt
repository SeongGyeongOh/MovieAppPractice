package com.osg.movieapppractice.data.api

import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
//    @Inject lateinit var apiService: ApiService

    override suspend fun getMovie(): String {
        return apiService.getMovie()
    }
}
