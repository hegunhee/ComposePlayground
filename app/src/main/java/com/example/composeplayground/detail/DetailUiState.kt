package com.example.composeplayground.detail

import com.example.domain.model.Todo

sealed class DetailUiState {

    object Loading : DetailUiState()

    data class Success(val todo : Todo) : DetailUiState()

    data class Error(val message : String) : DetailUiState()
}
