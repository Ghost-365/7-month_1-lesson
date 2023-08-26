package com.example.a7_month_1_lesson.data.repositories

import com.example.a7_month_1_lesson.data.database.Dao.ContactDao
import com.example.a7_month_1_lesson.data.mappers.mapToContactEntity
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import com.example.a7_month_1_lesson.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContactRepositoryImpl
@Inject constructor(
    private val contactDao : ContactDao
) : ContactRepository {

    private lateinit var contact: Contact

    override fun getContacts(): Flow<Resource<List<ContactEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = contactDao.getContacts()
                emit(Resource.Success(data.mapToContactEntity()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage))
            }
        }
    }

    override fun createContact(contact: ContactEntity): Flow<Resource<ContactEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.createContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun updateContact(contact: ContactEntity): Flow<Resource<ContactEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.updateContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }

    override fun deleteContact(contact: ContactEntity): Flow<Resource<ContactEntity>> {
        return flow {
            emit(Resource.Loading())
            try {
                Resource.Success(contactDao.deleteContact(contact))
            } catch (e: Exception) {
                Resource.Error(e.localizedMessage)
            }
        }
    }
}