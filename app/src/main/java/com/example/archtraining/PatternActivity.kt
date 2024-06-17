package com.example.archtraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.archtraining.viewmodel.PatternViewModel
import com.example.archtraining.viewmodel.PatternViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.example.archtraining.databinding.ActivityPatternBinding

class PatternActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatternBinding

    private lateinit var viewModel: PatternViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPatternBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = PatternViewModelFactory(this)
        viewModel = ViewModelProvider(this, factory).get(PatternViewModel::class.java)

        binding.searchButton.setOnClickListener {
            val patternName = binding.patternInput.text.toString()
            if (patternName.isNotEmpty()) {
                viewModel.searchPattern(patternName)
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            binding.loadingIndicator.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.pattern.observe(this) { pattern ->
            if (pattern != null) {
                binding.resultText.text = pattern.description
                binding.resultText.visibility = View.VISIBLE
            } else {
                binding.resultText.visibility = View.GONE
            }
        }

        viewModel.error.observe(this) { error ->
            if (error != null) {
                binding.resultText.text = error
                binding.resultText.visibility = View.VISIBLE
            }
        }
    }
}