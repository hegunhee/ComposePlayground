package com.example.composeplayground.todo.detail

import com.example.domain.model.Todo

sealed class TodoState() {

    object Loading : TodoState()

    data class Success(val todo : Todo) : TodoState()
}
