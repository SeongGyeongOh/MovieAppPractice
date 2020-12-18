package com.osg.movieapppractice.ui.login.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.osg.movieapppractice.ui.compose.*

@Composable
fun PasswordScreen(){
    Column(
            modifier = Modifier
                    .padding(start = 25.dp, end = 25.dp, top = 25.dp)
                    .fillMaxSize(),
    ) {
        TitleText(text = "비밀번호 재설정", modifier = Modifier.weight(1f))

        Column(modifier = Modifier.weight(8f)) {
            GuideText(text = "회원가입 시 등록한 이메일 주소와\n핸드폰번호를 입력해주세요", modifier = Modifier.weight(1f))

            Column(modifier = Modifier.weight(3f)) {
                MyTextField(text= "이메일", Modifier)
                Row() {
                    Column(Modifier.weight(3f)) {
                        MyTextField(text = "국가코드", modifier = Modifier)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column(Modifier.weight(7f)) {
                        MyTextField(text = "휴대폰번호", modifier = Modifier)
                    }
                }
            }
            Column(modifier = Modifier.weight(4f)) {

            }

        }

    }
}

@Preview
@Composable
fun Prev(){
    Surface(color = Color.White) {
        PasswordScreen()
    }
}