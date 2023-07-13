package com.example.composeplayground.third

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.thirdNavGraph() {
    third()
}

fun NavGraphBuilder.third() {
    composable(route = ThirdRoute.thirdRoute) {
        ThirdRootScreen()
    }
}