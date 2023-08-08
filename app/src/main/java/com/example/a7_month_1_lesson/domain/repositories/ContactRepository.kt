package com.example.a7_month_1_lesson.domain.repositories

import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun getContacts() : Flow<Resource<List<ContactEntity>>>

    fun createContact(contact: Contact) : Flow<Resource<ContactEntity>>

    fun updateContact(contact: Contact) : Flow<Resource<ContactEntity>>

    fun deleteContact(contact: Contact) : Flow<Resource<ContactEntity>>
}