package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Todo

@Entity
data class TodoEntity(
    @PrimaryKey
    val title : String,
    val isChecked : Boolean
) {

    fun toTodo() : Todo = Todo(this.title,this.isChecked)

}

fun List<TodoEntity>.toTodoList() : List<Todo> = this.map { it.toTodo() }
