package com.example.a7_month_1_lesson.data.mapper

import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity

fun List<Contact>.mapToContactEntity() = this.map {
    ContactEntity(
        id = it.id,
        name = it.name,
        number = it.number
    )
}