package com.osg.movieapppractice.ui.compose

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.CoreTextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Composable
//fun MyTextField(
//    textState: MutableState<TextFieldValue>,
//    label: String,
//    keyboardType: KeyboardType,
//    visualTransformation: VisualTransformation
//) {
//    TextField(
//        value = textState.value,
//        onValueChange = { textState.value = it },
//        modifier = Modifier
//            .padding(bottom = 24.dp)
//            .border(0.5.dp, Color.Black, RectangleShape),
//        backgroundColor = Color.White,
//        activeColor = Color.Black,
//        label = { Text(text = label) },
//        keyboardType = keyboardType,
//        visualTransformation = visualTransformation
//    )
//}


@Composable
fun MyTextField(
        text: String,
        modifier: Modifier
){
    val textState = remember{ mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier) {
        GuideText(text = text, modifier = Modifier)
        CoreTextField(
                value = textState.value,
                onValueChange = { textState.value = it} ,
                cursorColor = Color.Black,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
        )
    }
    Spacer(modifier = Modifier.background(Color.Black).fillMaxWidth().height(1.dp))
}

@Composable
fun TitleText(text: String, modifier: Modifier){
    Text(
            text = text,
            fontWeight = FontWeight.W800,
            fontSize = 30.sp,
            modifier = modifier
    )
}


@Composable
fun GuideText(text: String, modifier: Modifier){
    Text(
            text = text,
            fontSize = 14.sp,
            modifier = modifier
    )
}

@Composable
fun TextButton(
        text: String,
        onClick : () -> Unit
){
    Text(
            text = text,
            fontSize = 14.sp,
            modifier = Modifier.clickable( onClick = onClick )
    )
}

@Composable
fun CustomButton(
        text: String,
        modifier: Modifier,
        clickBtn: () -> Unit,
){
    Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black)
                    .clickable(onClick = clickBtn),
            alignment = Alignment.Center
    ){
        Text(
                text = text,
                color = Color.White,
                fontSize = 24.sp
        )
    }
}

@Composable
fun CustomButtonWhite(
        text: String,
        modifier: Modifier
){
    Box(
            modifier = modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .clickable(onClick = {}),
            alignment = Alignment.Center
    ){
        Text(
                text = text,
                color = Color.Black,
                fontSize = 24.sp
        )
    }
}

@Composable
fun AppBar(){
    TopAppBar() {
        
    }
}