package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.TodoDao
import com.example.data.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase(){

    abstract fun todoDao() : TodoDao

    companion object{
        const val APP_NAME = "todoDatabase.db"
    }
}