package com.example.domain.repository

import com.example.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo : Todo)

    suspend fun getAllTodoList() : List<Todo>

    fun getAllTodoListByFlow() : Flow<List<Todo>>

    suspend fun deleteAllTodoList()
}