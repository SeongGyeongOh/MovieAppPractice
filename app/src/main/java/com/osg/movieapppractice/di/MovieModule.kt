package com.osg.movieapppractice.di

import com.osg.movieapppractice.data.api.ApiHelper
import com.osg.movieapppractice.data.api.ApiHelperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class MovieModule {

    @Singleton
    @Binds
    abstract fun bindMovie(impl: ApiHelperImpl): ApiHelper
}
