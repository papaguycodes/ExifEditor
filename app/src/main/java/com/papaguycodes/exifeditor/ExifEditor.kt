package com.papaguycodes.exifeditor

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.papaguycodes.exifeditor.databinding.ActivityExifEditorBinding
import com.papaguycodes.exifeditor.models.ExifData
import com.papaguycodes.exifeditor.utils.ExifUtils
import java.io.IOException

class ExifEditor : AppCompatActivity() {

    private lateinit var binding: ActivityExifEditorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExifEditorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve image path from intent
        val imagePath = intent.getStringExtra("IMAGE_PATH") ?: return
        val exifDataList = getExifData(imagePath)
        
        // Set up RecyclerView with EXIF data
        binding.exifRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.exifRecyclerView.adapter = ExifAdapter(exifDataList)
    }

    private fun getExifData(imagePath: String): List<ExifData> {
        val exifDataList = mutableListOf<ExifData>()

        try {
            val exifInterface = ExifInterface(imagePath)
            ExifUtils.exifTags.keys.forEach { tag ->
                val value = exifInterface.getAttribute(tag) ?: "Not available"
                exifDataList.add(ExifData(tag, value))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return exifDataList
        // Applying Theme
        ThemeUtils.applyTheme(this)

        // Setting up Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exif_editor)
        
    }
}
