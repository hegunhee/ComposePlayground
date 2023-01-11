package com.example.composeplayground.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun TodoDialog(text : String,textChange : (String)-> Unit,dismissDialog : () -> Unit){
    Dialog(onDismissRequest = {  }) {
        TodoDialogContent(text,textChange,dismissDialog)
    }
}

@Composable
fun TodoDialogContent(text : String,textChange : (String)-> Unit,dismissDialog : () -> Unit,context : Context = LocalContext.current) {
    Column(Modifier.background(Color.White)) {
        Spacer(modifier = Modifier
            .height(12.dp)
            .fillMaxWidth()
        )
        Text(
            text ="할 일을 추가해 주세요",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize()
                .padding(vertical = 8.dp),
            fontSize = 16.sp,
            lineHeight = 17.sp
        )
        Spacer(modifier = Modifier
            .height(12.dp)
            .fillMaxWidth())
        TextField(value = text, onValueChange = textChange, singleLine = true, modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White
            ))
        Spacer(modifier = Modifier
            .height(12.dp)
            .fillMaxWidth())
        Button(onClick = dismissDialog, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),shape = RoundedCornerShape(24.dp)) {
            Text("추가", fontSize = 16.sp)
        }
        
    }
}


@Preview
@Composable
private fun TodoAddDialogTest(){
    var text by remember { mutableStateOf("") }
    val textChange : (String) -> Unit = {
        text = it
    }
    var openDialog by remember { mutableStateOf(true) }
    val dismissDialog : () -> Unit = {openDialog = false}
    if(openDialog){
        TodoDialog(text,textChange,dismissDialog)
    }else{

    }
}
