package com.example.a7_month_1_lesson.data.database.Dao

import androidx.room.*
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.utils.Resource
import java.util.concurrent.Flow

interface ContactDao {

    @Query("SELECT * FROM contacts")
    suspend fun getContacts() : List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)
}