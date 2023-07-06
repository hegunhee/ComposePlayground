package com.example.composeplayground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.navigation.TodoGraph
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun PlayGroundApp() {
    ComposePlaygroundTheme {
        val playGroundAppState = rememberPlayGroundAppState()
        NavHost(modifier = Modifier, navController = playGroundAppState.navController, startDestination = TodoGraph.todoRoute) {
            todoScreen(playGroundAppState::navigateDetailTodo)
            detailScreen(onBackStack = playGroundAppState::onBackStack)
        }
    }
}

@Composable
fun rememberPlayGroundAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
) : PlayGroundAppState {
    return remember(key1 = coroutineScope, key2 = navController) {
        PlayGroundAppState(
            coroutineScope,
            navController
        )
    }
}
class PlayGroundAppState(
    val coroutineScope : CoroutineScope,
    val navController : NavHostController
) {
    fun navigateDetailTodo(title : String) {
        navController.navigate(TodoGraph.detailTodoRoute(title))
    }

    fun onBackStack() {
        navController.popBackStack()
    }
}
