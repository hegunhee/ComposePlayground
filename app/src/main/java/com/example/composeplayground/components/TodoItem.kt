package com.example.composeplayground.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Todo

@Composable
fun TodoItem(todo : Todo, toggleTodo : (Todo) -> Unit, context : Context = LocalContext.current) {
    Surface(shape = RoundedCornerShape(percent = 50),modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)){
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = todo.title,
                modifier = Modifier.clickable { Toast.makeText(context, todo.title, Toast.LENGTH_SHORT).show() },
                fontSize = 30.sp,
            )
            Checkbox(checked = todo.isChecked, onCheckedChange = {
                toggleTodo(todo)
            })
        }
    }
}

@Preview
@Composable
private fun PreviewDataTextColumn() {
    Column() {
        TodoItem(Todo("청소하기", isChecked = true),{})
        TodoItem(Todo("밥먹기", isChecked = false),{})
    }
}

@Preview
@Composable
private fun PreviewDataTextLazyColumn() {
    LazyColumn(){
        items(100){
            val isChecked = it %3 == 0
            TodoItem(Todo("할일 $it", isChecked = isChecked),{})
        }
    }
}