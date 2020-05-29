package com.bancosantander.globallogicbryanescalona.util

import android.content.SharedPreferences
import androidx.core.content.edit
import org.koin.core.KoinComponent
import org.koin.core.inject

object AppPreferences: KoinComponent {

    private val preferences: SharedPreferences by inject()
    private const val SEARCH = "search"

    const val SHARED_PREFERENCES_NAME = "GlobalLogic"

    var searchItem: String?
        get() = preferences.getString(SEARCH, "")
        set(value) = preferences.edit {
            putString(SEARCH, value).apply()
        }

}