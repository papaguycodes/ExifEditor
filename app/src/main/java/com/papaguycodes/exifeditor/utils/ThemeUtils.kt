package com.papaguycodes.exifeditor.utils

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.yourapp.R

object ThemeUtils {

    fun applyTheme(context: Context) {
        val sharedPrefs = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val isDarkMode = sharedPrefs.getBoolean("dark_mode", true)
        
        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
    }
}
