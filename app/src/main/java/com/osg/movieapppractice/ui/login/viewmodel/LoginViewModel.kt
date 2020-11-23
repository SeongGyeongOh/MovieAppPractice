package com.osg.movieapppractice.ui.login.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osg.movieapppractice.ui.login.intent.LoginIntent
import com.osg.movieapppractice.ui.login.state.LoginState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class LoginViewModel @ViewModelInject constructor() : ViewModel() {
    val userIntent = Channel<LoginIntent>(Channel.UNLIMITED)
    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            _state.value = LoginState.Idle
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is LoginIntent.Login -> enterMainMovieActivity()
                }
            }
        }
    }

    private fun enterMainMovieActivity() {
        viewModelScope.launch {
            _state.value = try {
                LoginState.Login
            } catch (e: Exception) {
                LoginState.Error(e.stackTraceToString())
            }
        }
    }
}
