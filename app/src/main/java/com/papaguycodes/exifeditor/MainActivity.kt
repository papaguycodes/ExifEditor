package com.papaguycodes.exifeditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.papaguycodes.exifeditor.databinding.ActivityMainBinding
import com.papaguycodes.exifeditor.utils.ThemeUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Applying Theme
        ThemeUtils.applyTheme(this)

        // Setting up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Implement additional UI logic here
    }
}
