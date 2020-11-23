package com.osg.movieapppractice.moviedetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDetail()
        }
    }
}

@Composable
fun MovieDetail() {
    Text(text = "movie Detail Activity")
}

@Preview
@Composable
fun MovieDetailPrev() {
    MovieDetail()
}
