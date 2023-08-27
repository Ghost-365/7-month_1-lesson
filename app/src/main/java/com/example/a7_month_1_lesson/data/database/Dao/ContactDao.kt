package com.example.a7_month_1_lesson.data.database.Dao

import androidx.room.*
import com.example.a7_month_1_lesson.data.model.Contact

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