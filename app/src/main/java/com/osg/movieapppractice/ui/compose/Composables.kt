package com.osg.movieapppractice.ui.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun MyTextField(
    textState: MutableState<TextFieldValue>,
    label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation
) {
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = Modifier
            .padding(bottom = 24.dp)
            .border(0.5.dp, Color.Black, RectangleShape),
        backgroundColor = Color.White,
        activeColor = Color.Black,
        label = { Text(text = label) },
        keyboardType = keyboardType,
        visualTransformation = visualTransformation
    )
}
