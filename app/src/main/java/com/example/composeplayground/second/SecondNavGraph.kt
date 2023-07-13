package com.example.composeplayground.second

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.secondNavGraph() {
    second()
}

fun NavGraphBuilder.second() {
    composable(route = SecondRoute.secondRoute) {
        SecondRouteScreen()
    }
}