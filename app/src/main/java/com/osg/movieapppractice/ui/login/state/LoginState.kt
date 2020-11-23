package com.osg.movieapppractice.ui.login.state

sealed class LoginState {
    object Idle : LoginState()
    object Login : LoginState()
    data class Error(val error: String) : LoginState()
}
