package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composeplayground.navigation.TodoGraph
import com.example.composeplayground.screen.DetailErrorScreen
import com.example.composeplayground.screen.DetailScreenRoute
import com.example.composeplayground.screen.TodoScreenRoute
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme(darkTheme = false) {
                PlayGroundApp()
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    PlayGroundApp()
}

fun NavGraphBuilder.todoScreen(onClickDetailTodo : (String) -> Unit = {}){
    composable(route = TodoGraph.todoRoute){
        TodoScreenRoute(toNavigateDetail = onClickDetailTodo)
    }
}
fun NavGraphBuilder.detailScreen(onBackStack : () -> Unit){
    composable(route = TodoGraph.detailTodoRoute("{title}")){
        val title = it.arguments?.getString("title")
        if(title != null){
            DetailScreenRoute(todoTitle = title, onBackButtonClick = onBackStack)
        }else{
            DetailErrorScreen(onBackButtonClick = onBackStack)
        }
    }
}