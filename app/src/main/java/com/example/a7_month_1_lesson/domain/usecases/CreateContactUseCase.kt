package com.example.a7_month_1_lesson.domain.usecases

import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import javax.inject.Inject

class CreateContactUseCase @Inject constructor(
    private val contactRepository: ContactRepository
) {
    fun createContact(contact : Contact) = contactRepository.createContact(contact)
}