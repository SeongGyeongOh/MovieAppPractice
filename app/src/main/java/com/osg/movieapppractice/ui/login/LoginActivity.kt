package com.osg.movieapppractice.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.ui.compose.MyTextField
import com.osg.movieapppractice.ui.login.intent.LoginIntent
import com.osg.movieapppractice.ui.login.state.LoginState
import com.osg.movieapppractice.ui.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.state.observeForever {
            when (it) {
                is LoginState.Idle -> {}
                is LoginState.Login -> {
                    Toast.makeText(this, "dkdkdkdkdkd", Toast.LENGTH_SHORT).show()
                }
                is LoginState.Error -> {
                    Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                }
            }
        }

        fun enterLogin() {
            viewModel.viewModelScope.launch {
                viewModel.userIntent.send(LoginIntent.Login)
            }
        }

        setContent {
            LoginScreen(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                enterLogin()
            }
        }
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier,
    enterLogin: () -> Unit,
) {
    val idText = remember { mutableStateOf(TextFieldValue("")) }
    val pwText = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MyMovieApp",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        MyTextField(
            textState = idText,
            label = "아이디",
            keyboardType = KeyboardType.Ascii,
            visualTransformation = VisualTransformation.None
        )
        MyTextField(
            textState = pwText,
            label = "비밀번호",
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation()
        )
        Row {
            Text(
                text = AnnotatedString("로그인"),
                modifier = Modifier.clickable(onClick = enterLogin)
            )
        }
    }
}

@Preview
@Composable
fun LoginPrev() {
    Surface(color = Color.White) {
    }
}
