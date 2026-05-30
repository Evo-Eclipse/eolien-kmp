package com.example.rayfield.data.database

import androidx.room3.TypeConverter
import com.example.rayfield.data.xray.types.XrayKeyPair
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromXrayKeyPair(value: XrayKeyPair?): String? {
        return value?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toXrayKeyPair(value: String?): XrayKeyPair? {
        return value?.let { Json.decodeFromString(it) }
    }
}
