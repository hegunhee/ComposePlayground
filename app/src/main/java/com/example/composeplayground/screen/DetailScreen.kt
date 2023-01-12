package com.example.composeplayground.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.components.BackButton
import com.example.composeplayground.components.DeleteButton

@Composable
fun DetailScreen(back : () -> Unit,delete : () -> Unit,isChecked : Boolean = true) {
    Column(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 20.dp)) {
        BackButton(back)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Title", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "디테일 스크린", fontSize = 15.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "isDone", fontSize = 20.sp,modifier = Modifier.padding(end = 20.dp))
            Checkbox(checked = isChecked, onCheckedChange = {})
        }
        Spacer(modifier = Modifier.height(30.dp))
        DeleteButton(delete = delete)
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen(back = {},delete = {})
}