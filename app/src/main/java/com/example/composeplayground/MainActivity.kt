package com.example.composeplayground

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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
                val todoList = remember { mutableStateListOf<TodoEntity>() }
                var dialogOpen by remember { mutableStateOf(false) }
                val dismissDialog : () -> Unit = {dialogOpen = false}
                val openDialog : () -> Unit = {dialogOpen = true}
                val addTodo : (TodoEntity) -> Unit = { todo -> todoList.add(todo) }
                val resetTodo : () -> Unit = { todoList.clear() }
                val toggleTodo : (TodoEntity) -> Unit = { todo ->
                    val index = todoList.indexOf(todoList.find { it == todo })
                    todoList.removeAt(index)
                    todoList.add(index,TodoEntity(todo.todo,!todo.isChecked))
                }

                if(dialogOpen) {
                    var todoText by remember { mutableStateOf("") }
                    val todoTextChange : (String) -> Unit = { todoText = it}
                    TodoDialog(text = todoText, textChange = todoTextChange,addTodo = addTodo, dismissDialog = dismissDialog)
                }
                Column() {
                    Row(){
                        AddButton(openDialog)
                        Spacer(modifier = Modifier.width(10.dp))
                        if(todoList.size != 0){
                            ResetButton(resetTodo)
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    if(todoList.size == 0){
                        Text(text = EMPTY_LIST)
                    }else{
                        LazyColumn(){
                            items(todoList.size){
                                TodoItem(todo = todoList[it],toggleTodo)
                            }
                        }
                    }
                }
            }
        }
    }
}