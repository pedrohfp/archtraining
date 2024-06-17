package com.example.archtraining.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.archtraining.data.DataSource
import com.example.archtraining.data.PatternRepository

class PatternViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PatternViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PatternViewModel(getRepository()) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun getRepository(): PatternRepository {
        return PatternRepository(DataSource(context))
    }
}