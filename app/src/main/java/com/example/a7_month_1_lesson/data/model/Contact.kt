package com.example.a7_month_1_lesson.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contact")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: String,
)