package com.example.composeplayground.todo

import com.example.domain.model.Todo

interface TodoActionHandler {

    fun addTodo(todo : Todo)

    fun resetTodoList()

    fun toggleTodo(todo : Todo)
}