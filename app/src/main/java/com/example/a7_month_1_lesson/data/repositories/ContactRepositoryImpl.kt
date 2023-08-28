package com.example.a7_month_1_lesson.data.repositories

import com.example.a7_month_1_lesson.data.base.BaseRepository
import com.example.a7_month_1_lesson.data.database.Dao.ContactDao
import com.example.a7_month_1_lesson.data.mappers.mapToContactEntity
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import com.example.a7_month_1_lesson.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactRepositoryImpl
@Inject constructor(
    private val contactDao : ContactDao
) : ContactRepository,BaseRepository() {

    override fun getContacts(): Flow<Resource<List<ContactEntity>>> = makeRequest {
        contactDao.getContacts().mapToContactEntity()
    }

    override fun createContact(contact: Contact): Flow<Resource<Unit>> = makeRequest {
        contactDao.createContact(contact)
    }

    override fun updateContact(contact: Contact): Flow<Resource<Unit>> = makeRequest {
        contactDao.updateContact(contact)
    }


    override fun deleteContact(contact: Contact): Flow<Resource<Unit>> = makeRequest {
        contactDao.deleteContact(contact)
    }
}