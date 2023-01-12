package com.example.composeplayground


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeplayground.entity.TodoEntity
import com.example.domain.model.Todo
import com.example.domain.usecase.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val insertTodoUseCase: InsertTodoUseCase,
    private val getAllTodoListByFlowUseCase: GetAllTodoListByFlowUseCase,
    private val getAllTodoListUseCase: GetAllTodoListUseCase,
    private val deleteAllTodoListUseCase: DeleteAllTodoListUseCase,
    private val toggleTodoUseCase: ToggleTodoUseCase

): ViewModel() {

    var todoList =  getAllTodoListByFlowUseCase()
    private set

    var dialogOpen = mutableStateOf<Boolean>(false)
    private set

    private val _detailTitle : MutableSharedFlow<String> = MutableSharedFlow()
    val detailTitle : SharedFlow<String> = _detailTitle.asSharedFlow()

    fun addTodo(todo : Todo) {
        viewModelScope.launch {
            insertTodoUseCase(todo)
        }

    }

    fun resetTodoList() {
        viewModelScope.launch{
            deleteAllTodoListUseCase()
        }

    }

    fun toggleTodoList(todo : Todo){
        viewModelScope.launch {
            toggleTodoUseCase(todo.copy(isChecked = !todo.isChecked))
        }
    }

    fun dismissDialog() {
        dialogOpen.value = false
    }

    fun openDialog() {
        dialogOpen.value = true
    }

    fun toDetail(title : String) {
        viewModelScope.launch {
            _detailTitle.emit(title)
        }

    }

}