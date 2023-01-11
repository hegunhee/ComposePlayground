package com.example.composeplayground.components

import android.content.Context
import android.view.Surface
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.entity.TodoEntity

@Composable
fun TodoItem(todo : TodoEntity,toggleTodo : (TodoEntity) -> Unit, context : Context = LocalContext.current) {
    Surface(shape = RoundedCornerShape(percent = 50),modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 10.dp)){
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = todo.todo,
                modifier = Modifier
                    .clickable {
                        Toast
                            .makeText(context, todo.todo, Toast.LENGTH_SHORT)
                            .show()
                    },
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
        TodoItem(TodoEntity("청소하기", isChecked = true),{})
        TodoItem(TodoEntity("밥먹기", isChecked = false),{})
    }
}

@Preview
@Composable
private fun PreviewDataTextLazyColumn() {
    LazyColumn(){
        items(100){
            val isChecked = it %3 == 0
            TodoItem(TodoEntity("할일 $it", isChecked = isChecked),{})
        }
    }
}