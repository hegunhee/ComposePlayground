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
import com.example.composeplayground.components.DeleteButton
import com.example.composeplayground.detail.DetailViewModel
import com.example.domain.model.Todo

@Composable
fun DetailScreenRoute(todoTitle : String,onBackButtonClick : () -> Unit, viewModel : DetailViewModel = hiltViewModel()){
    viewModel.fetchTodo(todoTitle)
    DetailScreen(onBackButtonClick, viewModel::deleteTodo, todo = viewModel.todo.value)
}
@Composable
fun DetailScreen(onBackButtonClick: () -> Unit, onDeleteTodoClick : () -> Unit, todo : Todo?) {
    if(todo != null){
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
                onDeleteTodoClick()
                onBackButtonClick()
            }) {
                Text(text = "삭제",fontSize = 16.sp)
            }
        }
    }else{
        Text(text = "로딩중")
    }

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