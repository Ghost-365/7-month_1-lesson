package com.example.a7_month_1_lesson.domain.usecases.utils

sealed class UiState<T> {

        class Loading<T>: UiState<T>()
        class Success<T>(val data: T?) : UiState<T>()
        class Error<T>(val message: String): UiState<T>()
        class Empty<T>: UiState<T>()
}