package com.example.a7_month_1_lesson.data.mappers.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a7_month_1_lesson.data.database.ContactDatabase
import com.example.a7_month_1_lesson.data.database.Dao.ContactDao
import com.example.a7_month_1_lesson.data.repositories.ContactRepositoryImpl
import com.example.a7_month_1_lesson.domain.usecases.repositories.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.contracts.contract

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Singleton
    @Provides
    fun provideCountryDatabase(
        @ApplicationContext context: Context
    ): com.example.homework_1_month7.data.local.CountryDataBase = Room.databaseBuilder(
        context,
        com.example.homework_1_month7.data.local.CountryDataBase::class.java,
        "note_db"
    ).build()

    @Singleton
    @Provides
    fun provideCountryDao(contactDatabase: ContactDatabase) = contactDatabase.getContactDao()

    @Singleton
    @Provides
    fun provideContactDao(contactDatabase: ContactDatabase) =
        contactDatabase.getContactDao()

    @Provides
    fun provideContactRepository(contactDao: ContactDao) =
        ContactRepositoryImpl(contactDao)
}