package com.example.composeplayground

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                var itemList by remember {mutableStateOf(0) }
                val increaseItem : () -> Unit = {
                    itemList++ 
                }
                val resetItem : () -> Unit = {
                    itemList = 0
                }
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
                                DataText(number = it+1, context = context)
                            }
                        }
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

@Composable
fun DataText(number : Int,context : Context) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Title $number",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(context, "Title $number", Toast.LENGTH_SHORT)
                        .show()
                },
            fontSize = 30.sp,
        )
        Text(text = "subTitle $number", modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "SubTitle $number", Toast.LENGTH_SHORT)
                    .show()
            }, fontSize = 15.sp)
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(30.dp))
    }
}