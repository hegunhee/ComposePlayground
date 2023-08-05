package com.example.composeplayground.study.book.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(Modifier.size(width = 400.dp,height = 200.dp)) {
        val (button1, button2, button3) = createRefs()

        val guide = createGuidelineFromStart(fraction = .60f)

        CustomButton(text = "Button1", modifier = Modifier.constrainAs(button1) {
            top.linkTo(parent.top,margin = 30.dp)
            end.linkTo(guide,margin = 30.dp)
        })

        CustomButton(text = "Button2",modifier = Modifier.constrainAs(button2){
            top.linkTo(button1.bottom,margin = 20.dp)
            start.linkTo(guide,margin = 40.dp)
        })

        CustomButton(text = "Button3",modifier = Modifier.constrainAs(button3){
            top.linkTo(button2.top,margin = 40.dp)
            end.linkTo(guide,margin = 20.dp)
        })

    }
}

@Composable
fun CustomButton(text : String = "",modifier :Modifier = Modifier) {
    Button(onClick = { },modifier = modifier) {
        Text(text = text)
    }
}
