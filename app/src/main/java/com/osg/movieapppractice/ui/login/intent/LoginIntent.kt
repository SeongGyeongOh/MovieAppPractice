package com.osg.movieapppractice.ui.login.intent

sealed class LoginIntent {
    object Login : LoginIntent()
    object PasswordScreen : LoginIntent()
}
