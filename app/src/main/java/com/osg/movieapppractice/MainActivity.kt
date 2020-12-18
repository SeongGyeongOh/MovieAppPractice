package com.osg.movieapppractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContent{
//            LoginScreen { clickBtn() }
//        }
    }

    fun clickBtn(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}




@Preview
@Composable
private fun Prev(){
    Surface(color = Color.White) {
//        LoginScreen()
    }
}

