package com.example.archtraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.archtraining.databinding.ActivityPatternBinding

class PatternActivity: AppCompatActivity() {

    private lateinit var binding: ActivityPatternBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPatternBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}