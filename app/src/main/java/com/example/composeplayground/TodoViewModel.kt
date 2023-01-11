package com.example.composeplayground

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composeplayground.entity.TodoEntity

class TodoViewModel : ViewModel() {

    var todoList =  mutableStateListOf<TodoEntity>()
    private set

    fun addTodo(todo : TodoEntity){
        todoList.add(todo)
    }

    fun resetTodoList() {
        todoList.clear()
    }

    fun toggleTodoList(todo : TodoEntity){
        val index = todoList.indexOf(todoList.find { it == todo })
        todoList.removeAt(index)
        todoList.add(index,TodoEntity(todo.todo,!todo.isChecked))
    }


}