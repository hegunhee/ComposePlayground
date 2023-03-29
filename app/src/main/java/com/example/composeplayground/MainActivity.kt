package com.example.composeplayground

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.detail.DetailViewModel
import com.example.composeplayground.todo.TodoViewModel
import com.example.composeplayground.navigation.Screen
import com.example.composeplayground.screen.DetailErrorScreen
import com.example.composeplayground.screen.DetailScreen
import com.example.composeplayground.screen.TodoScreenRoute
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme(darkTheme = false) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Todo.route){
                    todoScreen(navController)
                    detailScreen(navController)
                }
            }
        }
    }
}

private fun NavGraphBuilder.todoScreen(navController: NavController){
    composable(route = Screen.Todo.route){
        val toNavigateDetail : (String) -> Unit = { detailTitle -> navController.navigate(Screen.DetailTodo.createRoute(detailTitle)) }
        TodoScreenRoute(toNavigateDetail = toNavigateDetail)
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
private fun NavGraphBuilder.detailScreen(navController: NavController){
    composable(route = Screen.DetailTodo.route){
        val viewModel : DetailViewModel = hiltViewModel()
        val title = it.arguments?.getString("title")
        if(title != null){
            viewModel.fetchTodo(title)
            val todo = viewModel.todo.collectAsState()
            if(todo.value != null){
                DetailScreen(onClickBack = viewModel::onClickBackButton, onClickDelete = viewModel::deleteTodo, todo = todo.value!!)
            }else{
                Text(text = "로딩중")
            }
        }else{
            DetailErrorScreen(back = viewModel::onClickBackButton)
        }
        LaunchedEffect(viewModel.backScreen){
            viewModel.backScreen.collect{
                navController.popBackStack()
            }
        }
    }
}