package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.dao.TodoDao
import com.example.data.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context : Context) : TodoDatabase {
        return Room.databaseBuilder(context,TodoDatabase::class.java,TodoDatabase.APP_NAME).build()
    }

    @Singleton
    @Provides
    fun provideTodoDao(database : TodoDatabase) : TodoDao{
        return database.todoDao()
    }
}