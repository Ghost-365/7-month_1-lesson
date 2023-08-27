package com.example.a7_month_1_lesson.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.a7_month_1_lesson.data.base.BaseActivity
import com.example.a7_month_1_lesson.data.model.Contact
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.usecases.utils.UiState
import com.example.homework_1_month7.R
import com.example.homework_1_month7.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<CountryViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contact = Contact(1,"first","second")
        createContact(contact)
        updateContact(contact)
        deleteContact(contact)
    }

    private fun getContact(contactEntity: ContactEntity) {
        viewModel.getAllContact.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }


    private fun createContact(contact: Contact) {
        viewModel.createAllContact(contact)
        viewModel.createAllContact.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }

    private fun updateContact(contact: Contact) {
        viewModel.updateAllContact(contact)
        viewModel.updateAllContact.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }

    private fun deleteContact(contact: Contact) {
        viewModel.deleteAllContact(contact)
        viewModel.deleteAllContact.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }
}