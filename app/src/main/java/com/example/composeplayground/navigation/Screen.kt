package com.example.composeplayground.navigation

import androidx.navigation.NavBackStackEntry

object TodoGraph {

    val todoRoute = "Todo"

    val detailRoute = "Detail/{title}"

    fun createDetailTodoRoute(title : String) = "Detail/$title"
}
