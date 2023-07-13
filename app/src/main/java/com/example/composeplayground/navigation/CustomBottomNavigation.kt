package com.example.composeplayground.navigation

import android.R
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry


@Composable
fun CustomBottomNavigation(backStackEntry : NavBackStackEntry?, onBottomClick : (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.darker_gray),
        contentColor = Color.Black
    ) {
        val navBackStateEntry = remember { mutableStateOf(backStackEntry) }
        val currentRoute = navBackStateEntry.value?.destination?.route
        BottomNavItem.items.forEachIndexed { index, item ->
            BottomNavigationItem(
                label = { Text(text = item.screen_route, fontSize = 9.sp) },
                icon =  {},
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {onBottomClick(index)}
            )
        }
    }
}