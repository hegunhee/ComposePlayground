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
    ConstraintLayout(Modifier.size(width = 400.dp,height = 200.dp)) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3)

        CustomButton(text = "Button1", modifier = Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        CustomButton(text = "Button2",modifier = Modifier.constrainAs(button2){
            centerVerticallyTo(parent)
        })

        CustomButton(text = "Button2",modifier = Modifier.constrainAs(button3){
            centerVerticallyTo(parent)
        })

    }
}

@Composable
fun CustomButton(text : String = "",modifier :Modifier = Modifier) {
    Button(onClick = { },modifier = modifier) {
        Text(text = text)
    }
}
