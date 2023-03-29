package com.example.composeplayground.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeplayground.R
import com.example.composeplayground.todo.TodoViewModel
import com.example.composeplayground.components.ResetButton
import com.example.composeplayground.components.TodoDialog
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.text.EMPTY_LIST
import com.example.domain.model.Todo

@Composable
fun TodoScreenRoute(toNavigateDetail : (String) -> Unit ,todoViewModel: TodoViewModel = hiltViewModel()) {
    val todoList: State<List<Todo>> = todoViewModel.todoList.collectAsState(initial = emptyList())
    TodoScreen(
        todoList = todoList.value,
        isDialogOpen = todoViewModel.dialogOpen.value,
        onAddTodoClick = todoViewModel::addTodo,
        dismissDialog = todoViewModel::dismissDialog,
        openDialog = todoViewModel::openDialog,
        onResetTodoListClick = todoViewModel::resetTodoList,
        toNavigateDetail = toNavigateDetail,
        onToggleTodoClick = todoViewModel::toggleTodo
    )
}

@Composable
fun TodoScreen(todoList : List<Todo>,isDialogOpen : Boolean,onAddTodoClick : (Todo) -> Unit, dismissDialog : () -> Unit,openDialog : () -> Unit,onResetTodoListClick : () -> Unit,toNavigateDetail: (String) -> Unit, onToggleTodoClick : (Todo) -> Unit){

    if (isDialogOpen) {
        var todoText by remember { mutableStateOf("") }
        val todoTextChange: (String) -> Unit = { todoText = it }
        TodoDialog(text = todoText, textChange = todoTextChange, addTodo = onAddTodoClick, dismissDialog = dismissDialog)
    }
    Scaffold(
        floatingActionButton = { FloatingActionButton(onClick = { openDialog() }, modifier = Modifier.padding(end = 10.dp, bottom = 10.dp)) {
            Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)

        } },

        ) {
        Column() {
            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                if (todoList.isNotEmpty()) {
                    ResetButton(onResetTodoListClick)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (todoList.isEmpty()) {
                Text(text = EMPTY_LIST)
            } else {
                LazyColumn() {
                    items(todoList.size) {
                        TodoItem(todo = todoList[it], onTodoDetailClick = toNavigateDetail, onTodoToggle = onToggleTodoClick)
                    }
                }
            }
        }
    }
}