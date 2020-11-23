package com.osg.movieapppractice.tab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tabs()
        }
    }
}

@Composable
fun Tabs() {
    Text(text = "tabs Activity")
}

@Preview
@Composable
fun TabsPrev() {
    Tabs()
}
