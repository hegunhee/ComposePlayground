package com.example.composeplayground.navigation

import android.R
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry


@Composable
fun CustomBottomNavigation(backStackEntry : State<NavBackStackEntry?>, onBottomClick : (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.darker_gray),
        contentColor = Color.Black
    ) {
        val currentRoute = backStackEntry.value?.destination?.route
        BottomNavItem.items.forEachIndexed { index, item ->
            BottomNavigationItem(
                label = { Text(text = item.screen_route, fontSize = 9.sp) },
                icon =  {
                        Icon(painter = painterResource(id = R.drawable.ic_input_add), contentDescription = item.screen_route)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {onBottomClick(index)}
            )
        }
    }
}