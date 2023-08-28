package com.example.a7_month_1_lesson.presentation

import com.example.a7_month_1_lesson.data.base.BaseViewModel
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.CreateContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.DeleteContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.GetContactUseCase
import com.example.a7_month_1_lesson.domain.usecases.UpdateConstantUseCase
import com.example.a7_month_1_lesson.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(

    private val getContactUseCase: GetContactUseCase,
    private val createContactUseCase: CreateContactUseCase,
    private val updateConstantUseCase: UpdateConstantUseCase,
    private val deleteContactUseCase: DeleteContactUseCase

) : BaseViewModel() {

    private val _getAllContactStateFlow =
        MutableStateFlow<UiState<List<ContactEntity>>>(UiState.Empty())
    val getAllContact: StateFlow<UiState<List<ContactEntity>>> = _getAllContactStateFlow

    private val _createContactStateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val createAllContact: StateFlow<UiState<Unit>> = _createContactStateFlow

    private val _updateContactStateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val updateConstant: StateFlow<UiState<Unit>> = _updateContactStateFlow

    private val _deleteContactStateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deletedContacts: StateFlow<UiState<Unit>> = _deleteContactStateFlow

    fun getAllCountry() {
        getContactUseCase.getContacts().collectData(_getAllContactStateFlow)
    }

    fun createAllContact(contact: Contact) {
        createContactUseCase.createContact(contact).collectData(_createContactStateFlow)
    }

    fun updateAllContact(contact: Contact) {
        updateConstantUseCase.updateContact(contact).collectData(_updateContactStateFlow)
    }

    fun deleteAllContact(contact: Contact) {
        deleteContactUseCase.deleteContact(contact).collectData(_deleteContactStateFlow)
    }
}