package com.example.a7_month_1_lesson.domain.repositories

import com.example.a7_month_1_lesson.data.model.Contact

interface ContactRepository {

    fun getContacts() : List<Contact>

    fun createContact(contact: Contact)

    fun updateContact(contact: Contact)

    fun deleteContact(contact: Contact)
}