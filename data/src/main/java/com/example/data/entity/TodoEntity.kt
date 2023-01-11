package com.example.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
    @PrimaryKey
    val title : String,
    val isChecked : Boolean
) {
}