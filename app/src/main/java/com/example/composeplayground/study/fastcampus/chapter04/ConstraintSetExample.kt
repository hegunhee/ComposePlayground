package com.example.composeplayground.study.fastcampus.chapter04

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstraintSetExample() {
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        // redBox에 대한 제약을 만드는 것
        constrain(redBox) {
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }


    }
    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
        ) {

        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
        )
    }
}
