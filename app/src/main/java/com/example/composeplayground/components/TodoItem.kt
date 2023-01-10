package com.example.composeplayground.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoItem(number : Int, context : Context = LocalContext.current) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Title $number",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(context, "Title $number", Toast.LENGTH_SHORT)
                        .show()
                },
            fontSize = 30.sp,
        )
        Text(text = "subTitle $number", modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "SubTitle $number", Toast.LENGTH_SHORT)
                    .show()
            }, fontSize = 15.sp)
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(30.dp))
    }
}

@Preview
@Composable
fun PreviewDataText() {
    TodoItem(number = 0)
}