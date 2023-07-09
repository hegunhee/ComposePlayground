package com.example.composeplayground.todo

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeplayground.navigation.Todo
import com.example.composeplayground.screen.DetailErrorScreen
import com.example.composeplayground.screen.DetailScreenRoute
import com.example.composeplayground.screen.TodoScreenRoute
fun NavGraphBuilder.todoNavGraph(
    onClickNavigateDetailTodo : (String) -> Unit,
    onClickDetailBackButton : () -> Unit
) {
    todoScreen(onClickNavigateDetailTodo)
    detailScreen(onClickDetailBackButton)
}

fun NavGraphBuilder.todoScreen(onClickDetailTodo : (String) -> Unit = {}){
    composable(route = Todo.todoRoute){
        TodoScreenRoute(toNavigateDetail = onClickDetailTodo)
    }
}
fun NavGraphBuilder.detailScreen(onBackStack : () -> Unit){
    composable(route = Todo.detailTodoRoute("{title}")){
        val title = it.arguments?.getString("title")
        if(title != null){
            DetailScreenRoute(todoTitle = title, onBackButtonClick = onBackStack)
        }else{
            DetailErrorScreen(onBackButtonClick = onBackStack)
        }
    }
}