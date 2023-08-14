package com.example.composeplayground.todo

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeplayground.AppScaffoldPaddingValues
import com.example.composeplayground.screen.DetailErrorScreen
import com.example.composeplayground.screen.DetailScreenRoute
import com.example.composeplayground.screen.TodoScreenRoute
fun NavGraphBuilder.todoNavGraph(
    paddingValues: PaddingValues,
    onClickNavigateDetailTodo : (String) -> Unit,
    onClickDetailBackButton : () -> Unit
) {
    todoScreen(paddingValues, onClickNavigateDetailTodo)
    detailScreen(onClickDetailBackButton)
}

fun NavGraphBuilder.todoScreen(paddingValues: PaddingValues,onClickDetailTodo : (String) -> Unit = {}){
    composable(route = TodoRoute.todoRoute){
        CompositionLocalProvider(AppScaffoldPaddingValues provides paddingValues) {
            TodoScreenRoute(onClickDetailTodo)
        }

    }
}
fun NavGraphBuilder.detailScreen(onBackStack : () -> Unit){
    composable(route = TodoRoute.detailTodoRoute("{title}")){
        val title = it.arguments?.getString("title")
        if(title != null){
            DetailScreenRoute(todoTitle = title, onBackButtonClick = onBackStack)
        }else{
            DetailErrorScreen(onBackButtonClick = onBackStack)
        }
    }
}