package com.example.data.dao

import androidx.room.*
import com.example.data.entity.TodoEntity
import com.example.domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo : TodoEntity)

    @Query("SELECT * FROM TodoEntity")
    suspend fun getAllTodoList() : List<TodoEntity>

    @Query("SELECT * FROM TodoEntity")
    fun getAllTodoListByFlow() : Flow<List<TodoEntity>>

    @Query("SELECT * FROM TodoEntity WHERE title LIKE :title")
    suspend fun getTodoByTitle(title : String) : TodoEntity

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("DELETE FROM TodoEntity")
    suspend fun deleteAllTodoList()

    @Update
    suspend fun toggleTodo(todo : TodoEntity)

}