package com.example.composeplayground.fastcampus.chapter5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

val LocalColorComposition = compositionLocalOf { Color.Black }

@Composable
fun CompositionLocalApp() {
    Column() {
        Text(text = "Color.Black",modifier = Modifier
            .background(LocalColorComposition.current)
            .fillMaxWidth())
        CompositionLocalProvider(LocalColorComposition provides Color.Magenta) {
            MagentaBackgroundText()
        }
    }
}

@Composable
fun MagentaBackgroundText() {
    Text(text = "Color.Magenta",modifier = Modifier.background(LocalColorComposition.current).fillMaxWidth())
    CompositionLocalProvider(LocalColorComposition provides Color.Blue) {
        BlueBackgroundText()
    }
}

@Composable
fun BlueBackgroundText() {
    Text(text = "Color.Blue",modifier = Modifier.background(LocalColorComposition.current).fillMaxWidth())
}