package com.osg.movieapppractice.ui.moviemain.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.osg.movieapppractice.data.repository.MovieMainRepository
import com.osg.movieapppractice.ui.moviemain.intent.MovieMainIntent
import com.osg.movieapppractice.ui.moviemain.state.MovieMainState
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ActivityScoped
class MovieMainViewModel@ViewModelInject constructor(
    private val repository: MovieMainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userIntent = Channel<MovieMainIntent>(Channel.UNLIMITED)
    private val _state = MutableLiveData<MovieMainState>()
    val state: LiveData<MovieMainState> get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent(){
        _state.value = MovieMainState.Idle
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when(it){
                    is MovieMainIntent.MovieList -> showMoviePage()
                }
            }
        }
    }

    private fun showMoviePage(){
        viewModelScope.launch {
            _state.value = try{
                MovieMainState.FetchMovie(repository.getMovie())
            }catch (e: Exception){
                MovieMainState.Error(e.stackTraceToString())
            }
        }
    }
}