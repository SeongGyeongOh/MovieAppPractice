package com.osg.movieapppractice.ui.login.screens

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.osg.movieapppractice.ui.compose.*

@Composable
fun LoginScreen(clickBtn: () -> Unit, clickPassword: () -> Unit) {
    Column(
            modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, top = 25.dp)
                    .fillMaxSize()
    ) {
        TitleText(text = "로그인", modifier = Modifier.weight(1f))
        Column(modifier = Modifier.weight(8f)) {
            Column(modifier = Modifier.weight(2f)) {
                MyTextField(text = "이메일", Modifier)
                MyTextField(text = "비밀번호", Modifier)
            }
            CustomButton(text = "로그인", modifier = Modifier.weight(1f), clickBtn)
            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(
                            text = "비밀번호를 잊으셨나요?",
                            onClick = clickPassword
                    )
                    TextButton(
                            text = "회원가입",
                            onClick = {}
                    )
                }

                Row (
                        modifier = Modifier.fillMaxWidth()
                ){
                    Spacer(
                            modifier = Modifier
                                    .height(1.dp)
                                    .background(Color.Black)
                                    .weight(0.4f)
                                    .align(Alignment.CenterVertically)
                    )
                    Text(
                            text = "OR",
                            modifier = Modifier.weight(0.1f),
                            textAlign = TextAlign.Center
                    )
                    Spacer(
                            modifier = Modifier
                                    .height(1.dp)
                                    .background(Color.Black)
                                    .weight(0.4f)
                                    .align(Alignment.CenterVertically)
                    )
                }
            }

            Column(modifier = Modifier.weight(4f)) {
                CustomButtonWhite(text = "카카오로 시작하기", modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                CustomButtonWhite(text = "네이버로 시작하기", modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                CustomButtonWhite(text = "구글계정 로그인", modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                CustomButtonWhite(text = "Apple로 로그인", modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(0.5f))
        }

    }

}


//@Composable
//fun LoginScreen(
//    modifier: Modifier,
//    enterLogin: () -> Unit,
//) {
//    val idText = remember { mutableStateOf(TextFieldValue("")) }
//    val pwText = remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "MyMovieApp",
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold,
//            fontSize = 24.sp,
//            modifier = Modifier.padding(bottom = 24.dp)
//        )
//        MyTextField(
//            textState = idText,
//            label = "아이디",
//            keyboardType = KeyboardType.Ascii,
//            visualTransformation = VisualTransformation.None
//        )
//        MyTextField(
//            textState = pwText,
//            label = "비밀번호",
//            keyboardType = KeyboardType.Password,
//            visualTransformation = PasswordVisualTransformation()
//        )
//        Row {
//            Text(
//                text = AnnotatedString("로그인"),
//                modifier = Modifier.clickable(onClick = enterLogin)
//            )
//        }
//
//        MyTextField(
//            modifier = Modifier
//        )
//    }
//}