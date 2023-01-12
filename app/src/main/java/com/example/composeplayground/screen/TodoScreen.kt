package com.example.composeplayground

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeplayground.components.AddButton
import com.example.composeplayground.components.ResetButton
import com.example.composeplayground.components.TodoDialog
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.text.EMPTY_LIST
import com.example.domain.model.Todo

@Composable
fun TodoScreen(todoViewModel: TodoViewModel){
    val todoList : State<List<Todo>> = todoViewModel.todoList.collectAsState(initial = emptyList())
    if(todoViewModel.dialogOpen.value) {
        var todoText by remember { mutableStateOf("") }
        val todoTextChange : (String) -> Unit = { todoText = it}
        TodoDialog(
            text = todoText, textChange = todoTextChange,
            addTodo = todoViewModel::addTodo, dismissDialog = todoViewModel::dismissDialog)
    }
    Column() {
        Row(){
            AddButton(todoViewModel::openDialog)
            Spacer(modifier = Modifier.width(10.dp))
            if(todoList.value.isNotEmpty()){
                ResetButton(todoViewModel::resetTodoList)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        if(todoList.value.isEmpty()){
            Text(text = EMPTY_LIST)
        }else{
            LazyColumn(){
                items(todoList.value.size){
                    TodoItem(todo = todoList.value[it],todoViewModel::toggleTodoList, toDetail = todoViewModel::toDetail)
                }
            }
        }
    }
}