package com.example.a7_month_1_lesson.data.database

import androidx.room.Database
import com.example.a7_month_1_lesson.data.database.Dao.ContactDao
import com.example.a7_month_1_lesson.data.model.Contact

@Database(entities = [Contact::class],[], 1)
abstract class ContactDatabase {
    abstract fun getContactDao() : ContactDao
}