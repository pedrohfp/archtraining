package com.example.archtraining.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.archtraining.data.PatternDTO
import com.example.archtraining.data.PatternRepository

class PatternViewModel(private val repository: PatternRepository) : ViewModel() {

    private val _pattern = MutableLiveData<PatternDTO?>()
    val pattern: LiveData<PatternDTO?> get() = _pattern

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun searchPattern(name: String) {
        _loading.value = true
        _error.value = null

        val result = repository.getPatternByName(name)
        if (result != null) {
            _pattern.value = result
        } else {
            _error.value = "Pattern not found"
        }
        _loading.value = false
    }
}