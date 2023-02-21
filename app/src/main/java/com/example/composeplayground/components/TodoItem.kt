package com.example.composeplayground.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeplayground.todo.TodoActionHandler
import com.example.domain.model.Todo

@Composable
fun TodoItem(todo : Todo, eventHandler : TodoActionHandler = hiltViewModel()) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp).border(width = 1.dp,color = Color.Black,shape = RoundedCornerShape(percent = 50))){
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.clickable { eventHandler.toDetail(todo.title) }) {
            Text(
                text = todo.title,
                fontSize = 30.sp,
            )
            Checkbox(checked = todo.isChecked, onCheckedChange = {
                eventHandler.toggleTodo(todo)
            })
        }
    }
}

@Preview
@Composable
private fun PreviewDataTextColumn() {
    Column() {
        TodoItem(Todo("청소하기", isChecked = true))
        TodoItem(Todo("밥먹기", isChecked = false))
    }
}

@Preview
@Composable
private fun PreviewDataTextLazyColumn() {
    LazyColumn(){
        items(100){
            val isChecked = it %3 == 0
            TodoItem(Todo("할일 $it", isChecked = isChecked))
        }
    }
}