package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeplayground.components.AddButton
import com.example.composeplayground.components.ResetButton
import com.example.composeplayground.components.TodoDialog
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.entity.TodoEntity
import com.example.composeplayground.text.EMPTY_LIST
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                val todoViewModel : TodoViewModel = viewModel()
                var dialogOpen by remember { mutableStateOf(false) }
                val dismissDialog : () -> Unit = {dialogOpen = false}
                val openDialog : () -> Unit = {dialogOpen = true}

                if(dialogOpen) {
                    var todoText by remember { mutableStateOf("") }
                    val todoTextChange : (String) -> Unit = { todoText = it}
                    TodoDialog(text = todoText, textChange = todoTextChange,addTodo = todoViewModel::addTodo, dismissDialog = dismissDialog)
                }
                Column() {
                    Row(){
                        AddButton(openDialog)
                        Spacer(modifier = Modifier.width(10.dp))
                        if(todoViewModel.todoList.size != 0){
                            ResetButton(todoViewModel::resetTodoList)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    if(todoViewModel.todoList.size == 0){
                        Text(text = EMPTY_LIST)
                    }else{
                        LazyColumn(){
                            items(todoViewModel.todoList.size){
                                TodoItem(todo = todoViewModel.todoList[it],todoViewModel::toggleTodoList)
                            }
                        }
                    }
                }
            }
        }
    }
}