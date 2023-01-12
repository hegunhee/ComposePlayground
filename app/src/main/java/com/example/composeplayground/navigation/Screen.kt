package com.example.composeplayground.navigation

import androidx.navigation.NavBackStackEntry

sealed class Screen(val route : String){

    object Todo : Screen("Todo")

    object DetailTodo : Screen("Detail/{title}") {
        fun createRoute(title : String) = "Detail/$title"
        fun getArgumentTitle(entry : NavBackStackEntry) : String? {
            return entry.arguments?.getString("title")
        }
    }

}
