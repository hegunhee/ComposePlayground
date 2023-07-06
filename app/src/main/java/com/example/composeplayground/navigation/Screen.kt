package com.example.composeplayground.navigation

object TodoGraph {

    const val todoRoute = "Todo"

    fun detailTodoRoute(title : String) = "Detail/$title"
}
