package com.example.composeplayground.components

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun AddButton(openDialog : () -> Unit) {
    Button(onClick = openDialog) {
        Text(text = "AddTodo", fontSize = 16.sp)
    }
}

@Composable
fun BackButton(back : () -> Unit){
    Button(onClick = back) {
        Text(text = "뒤로 가기", fontSize = 16.sp)
    }
}

@Composable
fun DeleteButton(delete : () -> Unit){
    Button(onClick = delete) {
        Text(text = "삭제",fontSize = 16.sp)
    }
}

@Preview
@Composable
fun ButtonPreview(){
    val context = LocalContext.current
    val onClick = { Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show()}
    AddButton(onClick)
}