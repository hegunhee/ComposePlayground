package com.example.composeplayground.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Todo
import com.example.domain.usecase.DeleteTodoUseCase
import com.example.domain.usecase.GetTodoByTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getTodoByTitleUseCase: GetTodoByTitleUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : ViewModel() {

    private val _backScreen : MutableSharedFlow<Unit> = MutableSharedFlow<Unit>()
    val backScreen : SharedFlow<Unit> = _backScreen.asSharedFlow()

    private val _todo : MutableState<Todo?> = mutableStateOf<Todo?>(null)
    val todo : State<Todo?>
    get() = _todo

    fun fetchTodo(title: String) {
        viewModelScope.launch {
            _todo.value = getTodoByTitleUseCase(title)
        }
    }

    fun deleteTodo(){
        viewModelScope.launch {
            todo.value?.let {
                deleteTodoUseCase(it)
                _backScreen.emit(Unit)
                _todo.value = null
            }
        }
    }


    fun onClickBackButton() {
        viewModelScope.launch {
            _backScreen.emit(Unit)
        }
    }
}