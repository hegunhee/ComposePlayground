package com.example.domain.repository

import com.example.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun insertTodo(todo : Todo)

    suspend fun getAllTodoList() : List<Todo>

    fun getAllTodoListByFlow() : Flow<List<Todo>>

    suspend fun getTodoByTitle(title : String) : Todo

    suspend fun deleteTodo(todo: Todo)

    suspend fun deleteAllTodoList()

    suspend fun toggleTodo(todo : Todo)
}