package com.example.composeplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeplayground.R
import com.example.composeplayground.todo.TodoViewModel
import com.example.composeplayground.components.TodoDialog
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.text.EMPTY_LIST
import com.example.domain.model.Todo

@Composable
fun TodoScreenRoute(toNavigateDetail : (String) -> Unit ,todoViewModel: TodoViewModel = hiltViewModel()) {
    val todoList: State<List<Todo>> = todoViewModel.todoList.collectAsState(initial = emptyList())
    TodoScreen(
        todoList = todoList.value,
        onClickAddTodo = todoViewModel::addTodo,
        onClickResetTodoList = todoViewModel::resetTodoList,
        toNavigateDetail = toNavigateDetail,
        onClickToggleTodo = todoViewModel::toggleTodo
    )
}

@Composable
fun TodoScreen(todoList : List<Todo>, onClickAddTodo : (Todo) -> Unit, onClickResetTodoList : () -> Unit, toNavigateDetail: (String) -> Unit, onClickToggleTodo : (Todo) -> Unit){
    var isDialogOpen by remember { mutableStateOf(false) }
    val dismissDialog = { isDialogOpen = false }
    val openDialog = {isDialogOpen = true}

    if (isDialogOpen) {
        val (todoText, onTodoTextChange) = remember { mutableStateOf("")}
        TodoDialog(text = todoText, textChange = onTodoTextChange, onClickAddTodo = onClickAddTodo, onClickDismissDialog = dismissDialog)
    }
    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = openDialog, modifier = Modifier.padding(end = 10.dp, bottom = 10.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
        } },) {
        Column() {
            if(todoList.isNotEmpty()) {
                Button(onClick = onClickResetTodoList,modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Reset", fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (todoList.isEmpty()) {
                Text(text = EMPTY_LIST)
            } else {
                LazyColumn() {
                    items(todoList) { todo ->
                        TodoItem(todo = todo, onTodoDetailClick = toNavigateDetail, onTodoToggle = onClickToggleTodo )
                    }
                }
            }
        }
    }
}