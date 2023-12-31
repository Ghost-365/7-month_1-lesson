package com.example.a7_month_1_lesson.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7_month_1_lesson.data.utils.Resource
import com.example.a7_month_1_lesson.data.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UiState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect {
                when (it) {
                    is Resource.Error -> {
                        _state.value = UiState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _state.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _state.value = UiState.Success(it.data)
                        } else {
                            println("You don't have it")
                        }
                    }
                }
            }
        }
    }
}