package com.osg.movieapppractice.ui.moviemain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class MovieMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieMain()
        }
    }
}

@Composable
fun MovieMain() {
    Text(text = "Movie Main Page")
}

@Preview
@Composable
fun MovieMainPrev() {
    MovieMain()
}
