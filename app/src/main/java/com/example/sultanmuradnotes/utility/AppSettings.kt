package com.example.sultanmuradnotes.utility

import kotlinx.serialization.Serializable

@Serializable
data class AppSettings(
    var isOn: Boolean = false,
    var fontSize: Double
)


