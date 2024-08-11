package com.papaguycodes.exifeditor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.papaguycodes.exifeditor.databinding.ActivityExifEditorBinding
import com.papaguycodes.exifeditor.utils.ExifUtils

class ExifEditor : AppCompatActivity() {

    private lateinit var binding: ActivityExifEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Applying Theme
        ThemeUtils.applyTheme(this)

        // Setting up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exif_editor)

        // Loading and editing EXIF data
        val exifData = ExifUtils.getExifDataFromFile(filePath = "your/file/path")
        // Populate UI with EXIF data
        binding.exifData = exifData
    }
}
