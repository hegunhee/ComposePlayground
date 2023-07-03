package com.example.composeplayground.fastcampus.chapter04

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 여러 박스들의 레퍼런스를 가져올 수 있는 createRefs
        // 최대 16개를 가져올 수 있음
        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        // constraintAs로 어떤 refs를 지정할지, 위치정보, margin을 설정 가능
        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Red)
            .constrainAs(redBox){
                bottom.linkTo(parent.bottom, margin=8.dp)
                end.linkTo(parent.end,margin = 4.dp)
            })

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Magenta)
            .constrainAs(magentaBox){
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

        }

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Green)
            .constrainAs(greenBox) {
                centerTo(parent)
            }) {

        }

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Yellow)
            .constrainAs(yellowBox) {
                start.linkTo(magentaBox.end)
                top.linkTo(magentaBox.bottom)
            }) {

        }

    }
}