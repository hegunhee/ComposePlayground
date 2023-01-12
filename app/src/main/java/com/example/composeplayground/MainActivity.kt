package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.Screen
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
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
        val viewModel : TodoViewModel = hiltViewModel()
        TodoScreen(todoViewModel = viewModel)
        LaunchedEffect(key1 = Unit){
            launch {
                viewModel.detailTitle.collect{ title ->
                    navController.navigate(Screen.DetailTodo.createRoute(title))
                }
            }
        }
    }
}

private fun NavGraphBuilder.detailScreen(navController: NavController){ 
    composable(route = Screen.DetailTodo.route){
        Column() {
            it.arguments?.getString("title")?.let {
                Text(text = it)
            } ?: kotlin.run {

            }
            Button(onClick = { navController.popBackStack() }) {

            }
        }

    }
}