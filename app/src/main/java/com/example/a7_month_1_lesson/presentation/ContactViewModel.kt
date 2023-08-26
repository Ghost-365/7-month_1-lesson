package com.example.a7_month_1_lesson.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.CreateContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.DeleteContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.GetContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.UpdateConstantUseCase
import com.example.a7_month_1_lesson.domain.utils.Resource
import com.example.a7_month_1_lesson.domain.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(

    private val getContactUseCase: GetContactUseCase,
    private val createContactUseCase: CreateContactUseCase,
    private val updateConstantUseCase: UpdateConstantUseCase,
    private val deleteContactUseCase: DeleteContactUseCase

) : ViewModel() {

    private val _getAllContactStateFlow = MutableStateFlow<UiState<List<ContactEntity>>>(UiState.Empty())
    val getAllContact: StateFlow<UiState<List<ContactEntity>>> = _getAllContactStateFlow

    private val _createContactStateFlow = MutableStateFlow<UiState<ContactEntity>>(UiState.Empty())
    val createAllContact: StateFlow<UiState<ContactEntity>> = _createContactStateFlow

    private val _updateContactStateFlow = MutableStateFlow<UiState<ContactEntity>>(UiState.Empty())
    val updateConstant: StateFlow<UiState<ContactEntity>> = _updateContactStateFlow

    private val _deleteContactStateFlow = MutableStateFlow<UiState<ContactEntity>>(UiState.Empty())
    val deletedContacts: StateFlow<UiState<ContactEntity>> = _deleteContactStateFlow

    fun getAllCountry() {
        viewModelScope.launch {
            getContactUseCase.getContacts().collect {
                when (it) {

                    is Resource.Error -> {
                        _getAllContactStateFlow.value = UiState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _getAllContactStateFlow.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getAllContactStateFlow.value = UiState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun createAllContact(contactEntity: ContactEntity) {
        viewModelScope.launch {
            createContactUseCase.createContact(contactEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _createContactStateFlow.value = UiState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _createContactStateFlow.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _createContactStateFlow.value = UiState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun updateAllContact(contactEntity: ContactEntity) {
        viewModelScope.launch {
            updateConstantUseCase.updateContact(contactEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _updateContactStateFlow.value = UiState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _updateContactStateFlow.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _updateContactStateFlow.value = UiState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun deleteAllContact(contactEntity: ContactEntity) {
        viewModelScope.launch {
            deleteContactUseCase.deleteContact(contactEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _deleteContactStateFlow.value = UiState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _deleteContactStateFlow.value = UiState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _updateContactStateFlow.value = UiState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}
//ДЗ-сделать в presentation логику для добавления, удаления и обновления элемента в viewModel