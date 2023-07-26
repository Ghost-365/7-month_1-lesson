package com.example.a7_month_1_lesson.data.repositories

import com.example.a7_month_1_lesson.data.database.Dao.ContactDao
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.repositories.ContactRepository

class ContactRepositoryImpl(
    private val contactDao : ContactDao
) : ContactRepository {

    override fun getContacts(): List<Contact> {
        contactDao.getContacts()
    }

    override fun createContact(contact: Contact) {
        contactDao.createContact(contact)
    }

    override fun updateContact(contact: Contact) {
        contactDao.updateContact(contact)
    }

    override fun deleteContact(contact: Contact) {
        contactDao.deleteContact(contact)
    }
}