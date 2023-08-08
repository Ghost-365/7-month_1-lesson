package com.example.a7_month_1_lesson.domain.usecases

import androidx.room.Insert
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.repositories.ContactRepository
import javax.inject.Inject

class UpdateConstantUseCase @Inject constructor(

    private val contactRepository: ContactRepository
) {

    fun updateContact(contact: Contact) = contactRepository.updateContact(contact)
}