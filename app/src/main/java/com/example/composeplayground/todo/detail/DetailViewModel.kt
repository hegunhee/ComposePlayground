package com.example.composeplayground.todo.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Todo
import com.example.domain.usecase.DeleteTodoUseCase
import com.example.domain.usecase.GetTodoByTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getTodoByTitleUseCase: GetTodoByTitleUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : ViewModel() {

    private val _todoState : MutableState<TodoState> = mutableStateOf<TodoState>(TodoState.Loading)
    val todoState : State<TodoState>
    get() = _todoState

    fun fetchTodo(title: String) {
        viewModelScope.launch {
            runCatching {
                _todoState.value = TodoState.Success(getTodoByTitleUseCase(title))
            }
        }
    }

    fun deleteTodo(todo : Todo){
        viewModelScope.launch {
            deleteTodoUseCase(todo)
            _todoState.value = TodoState.Loading
        }
    }
}