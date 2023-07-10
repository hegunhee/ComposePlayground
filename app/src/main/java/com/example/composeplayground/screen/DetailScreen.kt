package com.example.composeplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeplayground.components.BackButton
import com.example.composeplayground.todo.detail.DetailViewModel
import com.example.composeplayground.todo.detail.TodoState
import com.example.domain.model.Todo

@Composable
fun DetailScreenRoute(todoTitle : String,onBackButtonClick : () -> Unit, viewModel : DetailViewModel = hiltViewModel()){
    viewModel.fetchTodo(todoTitle)
    when(val todoState = viewModel.todoState.value) {
        TodoState.Loading -> {
            DetailLoadingScreen()
        }
        is TodoState.Success -> {
            DetailScreen(onBackButtonClick = onBackButtonClick, onDeleteTodoClick = viewModel::deleteTodo, todo = todoState.todo)
        }
    }
}
@Composable
fun DetailScreen(onBackButtonClick: () -> Unit, onDeleteTodoClick : (Todo) -> Unit, todo : Todo) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, top = 20.dp)) {
        BackButton(onBackButtonClick)
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
        Button(onClick = {
            onDeleteTodoClick(todo)
            onBackButtonClick()
        }) {
            Text(text = "삭제",fontSize = 16.sp)
        }
    }
}
@Composable
fun DetailLoadingScreen() {
    Text(text = "로딩중")
}

@Composable
fun DetailErrorScreen(onBackButtonClick : () -> Unit){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp)) {
        BackButton(onBackButtonClick)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "에러가 발생했습니다.", fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen(onBackButtonClick = {}, onDeleteTodoClick = {},todo=Todo("todo",false))
}