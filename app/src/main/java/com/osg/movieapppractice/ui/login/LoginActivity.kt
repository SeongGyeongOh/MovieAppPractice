package com.osg.movieapppractice.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.R
import com.osg.movieapppractice.navigation.Actions
import com.osg.movieapppractice.navigation.BackDispatcherAmbient
import com.osg.movieapppractice.navigation.Destination
import com.osg.movieapppractice.navigation.Navigator
import com.osg.movieapppractice.ui.login.screens.LoginScreen
import com.osg.movieapppractice.ui.login.screens.PasswordScreen
import com.osg.movieapppractice.ui.login.state.LoginState
import com.osg.movieapppractice.ui.login.viewmodel.LoginViewModel
import com.osg.movieapppractice.ui.moviemain.MovieMainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.out_left, R.anim.none)

        viewModel.state.observeForever {
            when (it) {
                is LoginState.Idle -> {}
                is LoginState.Login -> {
//                    Toast.makeText(this, "dkdkdkdkdkd", Toast.LENGTH_SHORT).show()
                }
                is LoginState.Error -> {
                    Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun enterLogin() {
//            viewModel.viewModelScope.launch {
//                viewModel.userIntent.send(LoginIntent.Login)
//            }
            val intent = Intent(this, MovieMainActivity::class.java)
            startActivity(intent)
        }

        setContent {
            LoginRootScreen(
                    backDispatcher = onBackPressedDispatcher
            ) { enterLogin() }
        }
    }
}

@Composable
fun LoginRootScreen(
        backDispatcher: OnBackPressedDispatcher,
        clickLogin: () -> Unit,
){

    val navigator: Navigator<Destination> = rememberSavedInstanceState(
            saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

    Scaffold(
            topBar = {
                TopAppBar(
                        backgroundColor = Color.White,
                        elevation = 0.dp
                ){}
            }
    ) {
        Providers(BackDispatcherAmbient provides backDispatcher) {
            Crossfade(current = navigator.current) { destination ->
                when (destination) {
                    is Destination.Home -> {
                        LoginScreen(
                                clickBtn = clickLogin,
                                clickPassword = actions.createPoll
                        )
                    }
                    is Destination.CreatePoll -> {
                        PasswordScreen()
                    }
                }
            }
        }
    }

}


@Preview
@Composable
fun LoginPrev() {
    Surface(modifier = Modifier.background(Color.White)) {

    }
}
