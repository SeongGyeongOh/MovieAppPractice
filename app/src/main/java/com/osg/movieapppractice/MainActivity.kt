package com.osg.movieapppractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.ui.login.LoginActivity
import com.osg.movieapppractice.ui.moviemain.intent.MovieMainIntent
import com.osg.movieapppractice.ui.moviemain.viewmodel.MovieMainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Modifier

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MovieMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContent{

        }

        lifecycleScope.launch {
            viewModel.userIntent.send(MovieMainIntent.MovieList)
        }
    }

    fun clickBtn(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}

//@Composable
//fun LoginScreen(
//    modifier: Modifier
//){
//    Column(
//
//    ) {
//
//    }
//}

