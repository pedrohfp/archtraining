package com.example.archtraining

class PatternRepository(private val dataSource: DataSource) {
    fun getPatternByName(name: String): PatternDTO? {
        return dataSource.getPatterns().find { it.name.equals(name, ignoreCase = true) }
    }
}