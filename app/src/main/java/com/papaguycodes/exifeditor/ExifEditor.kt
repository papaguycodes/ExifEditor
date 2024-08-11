package com.papaguycodes.exifeditor

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.papaguycodes.exifeditor.models.ExifData
import com.papaguycodes.exifeditor.utils.ExifUtils

class ExifEditor : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ExifAdapter
    private lateinit var exifDataList: MutableList<ExifData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exif_editor)

        exifDataList = ExifUtils.getExifDataFromImage("/path/to/image")
        recyclerView = findViewById(R.id.exifRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ExifAdapter(exifDataList)
        recyclerView.adapter = adapter

        // Add functionality to save edited tags
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            ExifUtils.saveExifDataToImage("/path/to/image", exifDataList)
            Toast.makeText(this, "Exif data saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
