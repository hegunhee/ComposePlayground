package com.example.domain.usecase

import com.example.domain.repository.TodoRepository
import javax.inject.Inject

class DeleteAllTodoListUseCase @Inject constructor(private val repository: TodoRepository){

    suspend operator fun invoke() {
        repository.deleteAllTodoList()
    }
}