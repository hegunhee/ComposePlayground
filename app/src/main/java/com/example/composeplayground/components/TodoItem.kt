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
import com.example.composeplayground.entity.TodoEntity

@Composable
fun TodoItem(todo : TodoEntity, context : Context = LocalContext.current) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = todo.todo,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(context, todo.todo, Toast.LENGTH_SHORT)
                        .show()
                },
            fontSize = 30.sp,
        )
        if(todo.isChecked) {
            Text(
                "it is cleared"
            )
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(30.dp))
    }
}

@Preview
@Composable
fun PreviewDataText() {
    TodoItem(TodoEntity("청소하기"))
}