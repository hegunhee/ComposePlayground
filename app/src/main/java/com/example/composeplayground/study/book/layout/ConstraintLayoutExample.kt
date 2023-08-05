package com.example.composeplayground.study.book.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(Modifier.size(width = 200.dp,height = 200.dp)) {
        val (button1, button2, button3) = createRefs()

        CustomButton(text = "Button1", modifier = Modifier.constrainAs(button1) {
            centerHorizontallyTo(parent)
            top.linkTo(parent.top)
            bottom.linkTo(button2.top)
        })

        CustomButton(text = "Button2",modifier = Modifier.constrainAs(button2){
            centerHorizontallyTo(parent)
            top.linkTo(button1.bottom)
            bottom.linkTo(parent.bottom)
        })

    }
}

@Composable
fun CustomButton(text : String = "",modifier :Modifier = Modifier) {
    Button(onClick = { },modifier = modifier) {
        Text(text = text)
    }
}
