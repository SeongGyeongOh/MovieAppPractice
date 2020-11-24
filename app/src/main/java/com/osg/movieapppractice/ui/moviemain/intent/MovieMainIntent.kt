package com.osg.movieapppractice.ui.moviemain.intent

sealed class MovieMainIntent {
    object MovieList : MovieMainIntent()
    object EnterDetail : MovieMainIntent()
}
