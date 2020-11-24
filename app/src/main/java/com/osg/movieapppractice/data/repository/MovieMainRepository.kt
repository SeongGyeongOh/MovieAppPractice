package com.osg.movieapppractice.data.repository

import com.osg.movieapppractice.data.api.ApiHelper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton

class MovieMainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getMovie() = apiHelper.getMovie()
}