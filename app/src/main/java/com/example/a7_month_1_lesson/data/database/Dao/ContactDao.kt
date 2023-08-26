package com.example.a7_month_1_lesson.data.database.Dao

import androidx.room.*
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity

interface ContactDao {

    @Query("SELECT * FROM contacts")
    suspend fun getContacts() : List<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createContact(contact: ContactEntity)

    @Update
    suspend fun updateContact(contact: ContactEntity)

    @Delete
    suspend fun deleteContact(contact: ContactEntity)
}