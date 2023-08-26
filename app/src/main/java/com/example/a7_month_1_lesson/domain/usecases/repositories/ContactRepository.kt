package com.example.a7_month_1_lesson.domain.usecases.repositories

import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun getContacts() : Flow<Resource<List<ContactEntity>>>

    fun createContact(contact: ContactEntity) : Flow<Resource<ContactEntity>>

    fun updateContact(contact: ContactEntity) : Flow<Resource<ContactEntity>>

    fun deleteContact(contact: ContactEntity) : Flow<Resource<ContactEntity>>
}