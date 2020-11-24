package com.osg.movieapppractice.ui.moviedetail

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Providers
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.rememberSavedInstanceState
import androidx.compose.ui.platform.setContent
import com.osg.movieapppractice.navigation.Actions
import com.osg.movieapppractice.navigation.BackDispatcherAmbient
import com.osg.movieapppractice.navigation.Destination
import com.osg.movieapppractice.navigation.Navigator

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDetail(backDispatcher = onBackPressedDispatcher)
        }
    }
}

@Composable
fun MovieDetail(backDispatcher: OnBackPressedDispatcher) {
    val navigator: Navigator<Destination> = rememberSavedInstanceState(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }

//    Column() {
//        Text(text = "movie Detail Activity")
//        Row() {
//            Button(onClick = {}) {
//                Text(text = "navigate to screen 1")
//            }
//            Button(onClick = {}) {
//                Text(text = "navigate to screen 2")
//            }
//            Button(onClick = {}) {
//                Text(text = "navigate to screen 3")
//            }
//        }
//    }

    Providers(BackDispatcherAmbient provides backDispatcher) {
//        ProvideDisplayInsets() {
        Crossfade(current = navigator.current) { destination ->
            when (destination) {
                is Destination.Home -> {
                    MovieDetailHome(
                        onCreateNextScreeen = actions.createPoll
                    )
                }
                is Destination.CreatePoll -> {
                    MovieDetailNext()
                }
            }
        }
//        }
    }
}

@Composable
fun MovieDetailHome(onCreateNextScreeen: () -> Unit) {
    Column() {
        Text(text = "Home")
        Button(onClick = onCreateNextScreeen) {
            Text(text = "navigate")
        }
    }
}

@Composable
fun MovieDetailNext() {
    Text(text = "NextScreen")
}

// @Preview
// @Composable
// fun MovieDetailPrev() {
//    MovieDetail()
// }
