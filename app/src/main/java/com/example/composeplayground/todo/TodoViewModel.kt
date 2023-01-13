package com.example.composeplayground.todo


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val deleteAllTodoListUseCase: DeleteAllTodoListUseCase,
    private val toggleTodoUseCase: ToggleTodoUseCase

): ViewModel(),TodoActionHandler{

    var todoList =  getAllTodoListByFlowUseCase()
    private set

    var dialogOpen = mutableStateOf<Boolean>(false)
    private set

    private val _detailTitle : MutableSharedFlow<String> = MutableSharedFlow()
    val detailTitle : SharedFlow<String> = _detailTitle.asSharedFlow()

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

    fun dismissDialog() {
        dialogOpen.value = false
    }

    fun openDialog() {
        dialogOpen.value = true
    }

    override fun toDetail(title : String) {
        viewModelScope.launch {
            _detailTitle.emit(title)
        }
    }

}