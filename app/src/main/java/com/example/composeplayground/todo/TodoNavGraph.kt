package com.example.composeplayground.todo

import androidx.navigation.NavGraphBuilder
import com.example.composeplayground.detailScreen
import com.example.composeplayground.todoScreen

fun NavGraphBuilder.todoNavGraph(
    onClickNavigateDetailTodo : (String) -> Unit,
    onClickDetailBackButton : () -> Unit
) {
    todoScreen(onClickNavigateDetailTodo)
    detailScreen(onClickDetailBackButton)
}