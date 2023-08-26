package com.example.a7_month_1_lesson.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.utils.UiState
import com.example.homework_1_month7.R
import com.example.homework_1_month7.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CountryViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactEntity: ContactEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactEntity = ContactEntity(1,"first","second")
        createContact(contactEntity)
        updateContact(contactEntity)
        deleteContact(contactEntity)
    }

    private fun getContact(contactEntity: ContactEntity) {
        viewModel.getAllContact
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllContact.collect {
                    when (it) {
                        is UiState.Loading -> {
                            println("Show progress bar")
                        }
                        is UiState.Success -> {
                            println("Show data in recycler view")
                        }
                        is UiState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Empty -> {


                        }
                    }
                }
            }
        }
    }

    private fun createContact(contactEntity: ContactEntity) {
        viewModel.createAllContact(this.contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.createAllContact.collect {
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Loading -> {
                            println("Show progress bar")
                        }
                        is UiState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun updateContact(contactEntity: ContactEntity) {
        viewModel.updateAllContact(this.contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateConstant.collect {
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Loading -> {
                            println("Show progress bar")
                        }
                        is UiState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun deleteContact(contactEntity: ContactEntity) {
        viewModel.deleteAllContact(this.contactEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.deletedContacts.collect {
                    when (it) {
                        is UiState.Empty -> {}
                        is UiState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UiState.Loading -> {
                            println("Show progress bar")
                        }
                        is UiState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
}