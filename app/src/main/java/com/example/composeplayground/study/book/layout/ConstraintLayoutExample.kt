package com.example.composeplayground.study.book.layout

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout {
        val text1 = createRef()

        Text(text = "Hello",modifier = Modifier.constrainAs(text1) {
            top.linkTo(parent.top,margin = 16.dp)
            bottom.linkTo(parent.bottom,margin= 16.dp)
            start.linkTo(parent.start,margin = 20.dp)
        }.background(Color.Magenta))
    }
}
