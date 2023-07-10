package com.example.composeplayground.todo


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Todo
import com.example.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val insertTodoUseCase: InsertTodoUseCase,
    private val getAllTodoListByFlowUseCase: GetAllTodoListByFlowUseCase,
    private val deleteAllTodoListUseCase: DeleteAllTodoListUseCase,
    private val toggleTodoUseCase: ToggleTodoUseCase
): ViewModel(),TodoActionHandler{

    var todoList =  getAllTodoListByFlowUseCase()
    private set

    override fun addTodo(todo : Todo) {
        viewModelScope.launch {
            insertTodoUseCase(todo)
        }

    }

    override fun resetTodoList() {
        viewModelScope.launch{
            deleteAllTodoListUseCase()
        }

    }

    override fun toggleTodo(todo : Todo){
        viewModelScope.launch {
            toggleTodoUseCase(todo.copy(isChecked = !todo.isChecked))
        }
    }
}