package com.example.composeplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.BackButton
import com.example.composeplayground.components.DeleteButton
import com.example.domain.model.Todo

@Composable
fun DetailScreen(onClickBack : () -> Unit, onClickDelete : () -> Unit, todo : Todo) {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 20.dp)) {
        BackButton(onClickBack)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Title", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = todo.title, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "isDone", fontSize = 20.sp,modifier = Modifier.padding(end = 20.dp))
            Checkbox(checked = todo.isChecked, onCheckedChange = {})
        }
        Spacer(modifier = Modifier.height(30.dp))
        DeleteButton(delete = onClickDelete)
    }
}

@Composable
fun DetailErrorScreen(back : () -> Unit){
    Column(Modifier.fillMaxWidth().padding(start = 20.dp, top = 20.dp)) {
        BackButton(back)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "에러가 발생했습니다.", fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen(onClickBack = {},onClickDelete = {},todo=Todo("todo",false))
}