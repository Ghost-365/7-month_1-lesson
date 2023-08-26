package com.example.a7_month_1_lesson.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.a7_month_1_lesson.domain.models.ContactEntity
import com.example.a7_month_1_lesson.domain.utils.UiState
import com.example.homework_1_month7.R
import com.example.homework_1_month7.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CountryViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactEntity: ContactEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getContact()
    }

    private fun getContact() {
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

    private fun createContact() {
        viewModel.createAllContact(contactEntity)
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

    private fun updateContact() {
        viewModel.updateAllContact(contactEntity)
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

    private fun deleteContact() {
        viewModel.deleteAllContact(contactEntity)
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