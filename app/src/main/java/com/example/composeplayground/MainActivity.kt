package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composeplayground.components.TodoItem
import com.example.composeplayground.entity.TodoEntity
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                var itemList by remember {mutableStateOf(0) }
                val increaseItem : () -> Unit = { itemList++ }
                val resetItem : () -> Unit = { itemList = 0 }
                val context = LocalContext.current
                if(itemList == 0){
                    ZeroItemList(increaseItem)
                }else{
                    Column() {
                        Row(Modifier.height(100.dp)){
                            Button(onClick = increaseItem,modifier = Modifier.padding(end = 10.dp)) {
                                Text(text = "it is $itemList")
                            }
                            Button(onClick = resetItem) {
                                Text(text = "reset Item")
                            }
                        }
                        LazyColumn(){
                            items(itemList){
                                TodoItem(todo = TodoEntity(todo = "할일 ${it+1}", isChecked = it%3 == 0),context = context)
                            }
                        }
//                        LazyColumn(){
//                            items(itemList){
//                                TodoItem(number = it+1, context = context)
//                            }
//                        }
                    }
                }
            }
        }
    }
}
@Composable
fun ZeroItemList(onClick : () -> Unit){
    Button(onClick = onClick){
        Text(text = "zero Item")
    }
}
