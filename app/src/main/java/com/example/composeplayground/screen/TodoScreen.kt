package com.example.composeplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composeplayground.R
import com.example.composeplayground.todo.TodoViewModel
import com.example.composeplayground.components.ResetButton
import com.example.composeplayground.components.TodoDialog
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.text.EMPTY_LIST
import com.example.domain.model.Todo

@Composable
fun TodoScreen(todoViewModel: TodoViewModel) {
    val todoList: State<List<Todo>> = todoViewModel.todoList.collectAsState(initial = emptyList())
    if (todoViewModel.dialogOpen.value) {
        var todoText by remember { mutableStateOf("") }
        val todoTextChange: (String) -> Unit = { todoText = it }
        TodoDialog(
            text = todoText, textChange = todoTextChange,
            addTodo = todoViewModel::addTodo, dismissDialog = todoViewModel::dismissDialog
        )
    }
    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = { todoViewModel.openDialog() }, modifier = Modifier.padding(end = 10.dp, bottom = 10.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)

        } },

    ) {
        Column() {
            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                if (todoList.value.isNotEmpty()) {
                    ResetButton(todoViewModel::resetTodoList)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (todoList.value.isEmpty()) {
                Text(text = EMPTY_LIST)
            } else {
                LazyColumn() {
                    items(todoList.value.size) {
                        TodoItem(todo = todoList.value[it], todoViewModel)
                    }
                }
            }
        }
    }
}