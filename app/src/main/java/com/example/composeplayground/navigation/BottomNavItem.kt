package com.example.composeplayground.navigation

import com.example.composeplayground.fourth.FourthRoute
import com.example.composeplayground.second.SecondRoute
import com.example.composeplayground.third.ThirdRoute
import com.example.composeplayground.todo.TodoRoute

sealed class BottomNavItem(val screen_route: String) {

    object Todo : BottomNavItem(TodoRoute.todoRoute)

    object Second : BottomNavItem(SecondRoute.secondRoute)

    object Third : BottomNavItem(ThirdRoute.thirdRoute)

    object Fourth : BottomNavItem(FourthRoute.fourthRoute)

    companion object {
        val items = listOf(
            Todo,
            Second,
            Third,
            Fourth
        )
    }
}
