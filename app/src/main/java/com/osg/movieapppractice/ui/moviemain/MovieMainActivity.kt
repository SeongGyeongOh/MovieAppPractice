package com.osg.movieapppractice.ui.moviemain

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.ui.moviemain.state.MovieMainState
import com.osg.movieapppractice.ui.moviemain.viewmodel.MovieMainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieMainActivity : AppCompatActivity() {
    private val viewModel: MovieMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                MovieMainScreen(viewModel)
        }
    }
}

@Composable
fun Idle(){
    Text(text = "asdfasdf")
}

@Composable
fun MovieMainScreen(viewModel: MovieMainViewModel) {
    val currentState by viewModel.state.observeAsState()
    when(currentState){
        is MovieMainState.Idle -> {}
        is MovieMainState.FetchMovie -> {
            TopMovieList(
                (currentState as MovieMainState.FetchMovie).movieData
            )
        }
    }
}

@Composable
fun TopMovieList(movieData: String) {
    Log.i("dataTest", movieData)
}

@Preview
@Composable
fun MovieMainPrev() {
//    MovieMain()
}
