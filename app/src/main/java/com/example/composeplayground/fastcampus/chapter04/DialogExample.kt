package com.example.composeplayground.fastcampus.chapter04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogExample() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }
    
    
    Column {
        Button(onClick = {
            openDialog = true
        }) {
            Text("다이얼로그 열기")
        }
        Text(text = "카운터: $counter")
    }
    
    if(openDialog){
        Dialog(onDismissRequest = {

        }) {
            Surface {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = "버튼을 클릭해주세요.\n * +1을 누르면 값이 증가됩니다.\n -1을 누르면 값이 감소됩니다.")
                    Row(modifier = Modifier.align(alignment = Alignment.End)) {
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter++
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                            counter--
                        }) {
                            Text("-1")
                        }
                    }
                }
            }
        }
    }
}