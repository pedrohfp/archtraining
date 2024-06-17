package com.example.archtraining

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

class DataSource(private val context: Context) {
    fun getPatterns(): List<PatternDTO> {
        val inputStream = context.assets.open("patterns.json")
        val reader = InputStreamReader(inputStream)
        val patternType = object : TypeToken<List<PatternDTO>>() {}.type
        return Gson().fromJson(reader, patternType)
    }
}