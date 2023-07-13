package com.example.composeplayground.fourth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.fourthNavGraph() {
    fourth()
}

fun NavGraphBuilder.fourth() {
    composable(FourthRoute.fourthRoute) {
        FourthRootScreen()
    }
}