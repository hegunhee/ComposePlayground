package com.example.composeplayground

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.todo.TodoRoute
import com.example.composeplayground.todo.todoNavGraph
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.coroutines.CoroutineScope

@Composable
fun PlayGroundApp() {
    ComposePlaygroundTheme {
        val playGroundAppState = rememberPlayGroundAppState()
        NavHost(modifier = Modifier, navController = playGroundAppState.navController, startDestination = TodoRoute.todoRoute) {
            todoNavGraph(
                playGroundAppState::navigateDetailTodo,
                playGroundAppState::onBackStack
            )
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
        navController.navigate(TodoRoute.detailTodoRoute(title))
    }

    fun onBackStack() {
        navController.popBackStack()
    }

    fun navigateBottomNavigation(index : Int) {
        navController.navigate(BottomNavItem.items[index].screen_route) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun getCurrentBackStackEntry(): NavBackStackEntry? {
        return navController.currentBackStackEntry
    }
}
