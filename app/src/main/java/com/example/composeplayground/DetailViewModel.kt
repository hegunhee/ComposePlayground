package com.example.composeplayground

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Todo
import com.example.domain.usecase.DeleteTodoUseCase
import com.example.domain.usecase.GetTodoByTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
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

    private val _todo : MutableStateFlow<Todo?> = MutableStateFlow(null)
    val todo : StateFlow<Todo?> = _todo.asStateFlow()



    fun fetchTodo(title: String) {
        viewModelScope.launch {
            runCatching {
                _todo.emit(getTodoByTitleUseCase(title))
            }
        }
    }

    fun deleteTodo(){
        viewModelScope.launch {
            todo.value?.let {
                deleteTodoUseCase(it)
                _backScreen.emit(Unit)
                _todo.emit(null)
            }
        }
    }


    fun onClickBackButton() {
        viewModelScope.launch {
            _backScreen.emit(Unit)
        }
    }
}