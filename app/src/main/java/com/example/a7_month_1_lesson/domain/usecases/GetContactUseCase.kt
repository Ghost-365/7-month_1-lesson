package com.example.a7_month_1_lesson.domain.usecases

import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import javax.inject.Inject

class GetContactUseCase @Inject constructor(
    private val repository: ContactRepository
) {
    fun getContacts() = repository.getContacts()
}