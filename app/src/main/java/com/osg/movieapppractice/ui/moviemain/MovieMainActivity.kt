package com.osg.movieapppractice.ui.moviemain

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawerLayout
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.osg.movieapppractice.R
import com.osg.movieapppractice.ui.moviedetail.MovieDetailActivity
import com.osg.movieapppractice.ui.moviemain.intent.MovieMainIntent
import com.osg.movieapppractice.ui.moviemain.state.MovieMainState
import com.osg.movieapppractice.ui.moviemain.viewmodel.MovieMainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieMainActivity : AppCompatActivity() {
    private val viewModel: MovieMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.in_bottom, R.anim.none)

        viewModel.state.observe(this) {
            when (it) {
                is MovieMainState.Idle -> {
                    setContent {
                        MovieMainLayout(
                            changeState = { changeState() },
                            changeActivity = { changeActivity() },
                            state = viewModel.state
                        )
                    }
                }
                is MovieMainState.FetchMovie -> {
                    setContent {
                        MovieMainLayout(
                            changeState = { changeState() },
                            changeActivity = { changeActivity() },
                            state = viewModel.state
                        )
                    }
                }
            }
        }
    }

    private fun changeState() {
        viewModel.viewModelScope.launch {
            viewModel.userIntent.send(MovieMainIntent.MovieList)
        }
    }

    private fun changeActivity() {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}

@Composable
fun MovieMainLayout(
    changeState: () -> Unit,
    changeActivity: () -> Unit,
    state: LiveData<MovieMainState>,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalDrawerLayout(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            DrawerContent(changeActivity = { changeActivity() })
        },
        bodyContent = {
            MovieMainScreen(
                changeState = changeState,
                state = state
            )
        }
    )
}

@Composable
fun MovieMainScreen(
    changeState: () -> Unit,
    state: LiveData<MovieMainState>,
) {

    Button(onClick = changeState) {
        Text(text = "test")
    }

    val currentState = state
    when (currentState.value) {
        is MovieMainState.Idle -> {}
        is MovieMainState.FetchMovie -> {
            TopMovieList(movieData = (currentState.value as MovieMainState.FetchMovie).movieData)
        }
    }
}

@Composable
fun TopMovieList(movieData: String) {
    Log.i("dataTest", movieData)
    Text(text = movieData)
}

@Composable
fun DrawerContent(
    changeActivity: () -> Unit
) {
    Column() {
        Button(onClick = {}) {
            Text(text = "to next composable screen")
        }
        Button(onClick = changeActivity) {
            Text(text = "to next Activity")
        }
    }
}
