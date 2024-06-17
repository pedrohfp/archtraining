package com.example.archtraining

data class PatternDTO(
    val name: String,
    val description: String,
    val advantages: List<String>,
    val disadvantages: List<String>,
    val usageExamples: List<String>
)