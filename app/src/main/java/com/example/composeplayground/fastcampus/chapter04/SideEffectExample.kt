package com.example.composeplayground.fastcampus.chapter04

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun SideEffectExample(lifecycleOwner : LifecycleOwner = LocalLifecycleOwner.current ){
    val scaffoldState = rememberScaffoldState()


    // 맨처음 이 함수가 호출될때 실행되지만 해당 상태가 변하기 전까지는
    // Recomposition되더라도 재 호출되지 않음


    LaunchedEffect(scaffoldState.snackbarHostState) {
        scaffoldState.snackbarHostState.showSnackbar("헬로 컴포즈~ ")
    }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_START -> {
                    Log.d("이펙트", "ON_START")
                }
                Lifecycle.Event.ON_STOP -> {
                    Log.d("이펙트","ON_STOP")
                }
                Lifecycle.Event.ON_PAUSE -> {
                    Log.d("이펙트","ON_PAUSE")
                }
                Lifecycle.Event.ON_RESUME -> {
                    Log.d("이펙트","ON_RESUME")
                }
                else -> {
                    Log.d("이펙트","그외!")
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    Scaffold(
        scaffoldState = scaffoldState
    ) {

    }
}