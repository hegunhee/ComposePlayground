package com.example.composeplayground


import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composeplayground.entity.TodoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(): ViewModel() {

    var todoList =  mutableStateListOf<TodoEntity>()
    private set

    
    var a = flow<TodoEntity> {  }
    var dialogOpen = mutableStateOf<Boolean>(false)
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

    fun dismissDialog() {
        dialogOpen.value = false
    }

    fun openDialog() {
        dialogOpen.value = true
    }


}