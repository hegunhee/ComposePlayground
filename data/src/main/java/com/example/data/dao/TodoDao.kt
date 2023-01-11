package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo : TodoEntity)

    @Query("SELECT * FROM TodoEntity")
    suspend fun getAllTodoList() : List<TodoEntity>

    @Query("SELECT * FROM TodoEntity")
    fun getAllTodoListByFlow() : Flow<List<TodoEntity>>

    @Query("DELETE FROM TodoEntity")
    suspend fun deleteAllTodoList()

}