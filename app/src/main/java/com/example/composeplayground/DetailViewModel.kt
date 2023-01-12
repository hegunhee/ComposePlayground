package com.example.composeplayground

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private val _backScreen : MutableSharedFlow<Unit> = MutableSharedFlow<Unit>()
    val backScreen : SharedFlow<Unit> = _backScreen.asSharedFlow()

    fun onClickBackButton() {
        viewModelScope.launch {
            _backScreen.emit(Unit)
        }
    }
}