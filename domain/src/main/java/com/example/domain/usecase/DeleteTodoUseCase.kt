package com.example.domain.usecase

import com.example.domain.model.Todo
import com.example.domain.repository.TodoRepository
import javax.inject.Inject

class DeleteTodoUseCase @Inject constructor(private val repository: TodoRepository) {

    suspend operator fun invoke(todo : Todo)  {
        return repository.deleteTodo(todo)
    }
}