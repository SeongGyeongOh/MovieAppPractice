package com.osg.movieapppractice.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }
}

@Composable
fun Login() {
    Text(text = "Login Activity")
}

@Preview
@Composable
fun LoginPrev() {
    Login()
}
