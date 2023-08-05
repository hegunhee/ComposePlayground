package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplayground.study.book.layout.ConstraintLayoutExample
import com.example.composeplayground.study.book.layout.LayoutExample
import com.example.composeplayground.study.fastcampus.chapter5.CompositionLocalApp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme(darkTheme = false) {
                ConstraintLayoutExample()
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    ConstraintLayoutExample()
}
