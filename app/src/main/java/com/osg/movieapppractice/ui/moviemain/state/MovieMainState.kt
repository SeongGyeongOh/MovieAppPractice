package com.osg.movieapppractice.ui.moviemain.state

import com.osg.movieapppractice.data.model.MovieComponent

sealed class MovieMainState{
    object Idle: MovieMainState()
    object Loading: MovieMainState()
    data class FetchMovie(val movieData: String): MovieMainState()
    data class Error(val error: String): MovieMainState()
}