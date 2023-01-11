package com.example.data.repository

import com.example.data.dao.TodoDao
import com.example.data.entity.TodoEntity
import com.example.data.entity.toTodoList
import com.example.domain.model.Todo
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultTodoRepository @Inject constructor(private val todoDao: TodoDao) : TodoRepository{
    override suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(TodoEntity(todo.title,todo.isChecked))
    }

    override suspend fun getAllTodoList(): List<Todo> {
        return todoDao.getAllTodoList().map { it.toTodo() }
    }

    override fun getAllTodoListByFlow(): Flow<List<Todo>> {
        return todoDao.getAllTodoListByFlow().map { it.toTodoList() }
    }

    override suspend fun deleteAllTodoList() {
        todoDao.deleteAllTodoList()
    }

    override suspend fun toggleTodo(todo: Todo) {
        todoDao.toggleTodo(TodoEntity(todo.title,todo.isChecked))
    }


}