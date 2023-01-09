package com.example.composeplayground

import android.content.Context
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                val context = LocalContext.current
                LazyColumn(modifier = Modifier) {
                    items(100){
                        DataText(number = it,context)
                    }
                }
            }
        }
    }
}

@Composable
fun DataText(number : Int,context : Context) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Title $number",
            modifier = Modifier
                .fillMaxWidth()
                .clickable { Toast.makeText(context, "Title $number", Toast.LENGTH_SHORT).show() },
            fontSize = 30.sp,
        )
        Text(text = "subTitle $number", modifier = Modifier
            .fillMaxWidth()
            .clickable { Toast.makeText(context, "SubTitle $number", Toast.LENGTH_SHORT).show() }, fontSize = 15.sp)
        Spacer(Modifier.fillMaxWidth().height(30.dp))
    }
}