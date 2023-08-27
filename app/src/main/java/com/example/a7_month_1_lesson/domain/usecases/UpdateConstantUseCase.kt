package com.example.a7_month_1_lesson.domain.usecases

import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import javax.inject.Inject

class UpdateConstantUseCase @Inject constructor(
    private val contactRepository: ContactRepository
) {
    fun updateContact(contact: Contact) = contactRepository.updateContact(contact)
}