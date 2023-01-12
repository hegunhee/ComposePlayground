package com.example.composeplayground.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.domain.model.Todo

@Composable
fun AddButton(openDialog : () -> Unit) {
    Button(onClick = openDialog) {
        Text(text = "AddTodo", fontSize = 16.sp)
    }
}

@Composable
fun ResetButton(resetTodo : () -> Unit){
    Button(onClick = resetTodo) {
        Text(text = "resetTodo", fontSize = 16.sp)
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