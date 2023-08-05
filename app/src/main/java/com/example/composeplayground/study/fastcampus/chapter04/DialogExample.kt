package com.example.composeplayground.study.fastcampus.chapter04

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

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
        AlertDialog(onDismissRequest = {
            openDialog = false
        }, confirmButton = {
            Button(onClick = {
                counter++
                openDialog = false
            }) {
                Text(text = "더하기")
            }
        }, dismissButton = {
            Button(onClick = {
                openDialog = false
            }) {
                Text(text = "취소")
            }
        },title = {
                  Text(text = "더하기")
        }, text = {
            Text(text = "더하기 버튼을 눌러주세요")
        })
    }
}