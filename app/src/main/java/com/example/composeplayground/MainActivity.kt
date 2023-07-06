package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.fastcampus.chapter04.ConstraintLayoutExample
import com.example.composeplayground.fastcampus.chapter04.ConstraintSetExample
import com.example.composeplayground.fastcampus.chapter04.DialogExample
import com.example.composeplayground.fastcampus.chapter04.SideEffectExample
import com.example.composeplayground.navigation.Screen
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
                SideEffectExample()
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    SideEffectExample()
}

private fun NavGraphBuilder.todoScreen(navController: NavController){
    composable(route = Screen.Todo.route){
        val toNavigateDetail : (String) -> Unit = { detailTitle -> navController.navigate(Screen.DetailTodo.createRoute(detailTitle)) }
        TodoScreenRoute(toNavigateDetail = toNavigateDetail)
    }
}
private fun NavGraphBuilder.detailScreen(navController: NavController){
    composable(route = Screen.DetailTodo.route){
        val toPopBackStack : () -> Unit = {navController.popBackStack()}
        val title = it.arguments?.getString("title")
        if(title != null){
            DetailScreenRoute(todoTitle = title, onBackButtonClick = toPopBackStack)
        }else{
            DetailErrorScreen(onBackButtonClick = toPopBackStack)
        }
    }
}